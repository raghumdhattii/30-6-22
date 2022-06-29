package com.flightApplication.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.flightApplication.entity.Airline;
import com.flightApplication.entity.Flight;
import com.flightApplication.exception.RecordNotFoundException;
import com.flightApplication.repository.AirlineRepository;
import com.flightApplication.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightrepo;

	@Autowired
	private AirlineRepository airlinerepo;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final String TOPIC = "kafka_topic";

	@KafkaListener(topics = TOPIC, groupId = "group_id", containerFactory = "userKafkaListenerFactory")

	public Flight addFlight(int airlineid, Flight flight) throws SQLException, NullPointerException {

		Optional<Airline> airline = airlinerepo.findById(airlineid);

		if (airline.isPresent()) {
			Airline airlinecompany = airline.get();
			flight.setAirline(airlinecompany);
			return flightrepo.save(flight);

		} else {
			throw new NoSuchElementException("Cannot add flight , Try with valid data");
		}

	}

	public Flight updateFlight(int airlineid, int flightid, Flight flight)
			throws NullPointerException, SQLException, RecordNotFoundException {

		if (flightrepo.existsById(flightid)) {

			if (airlinerepo.existsById(airlineid)) {

				Optional<Airline> airline = airlinerepo.findById(airlineid);
				flight.setAirline(airline.get());
				flight.setFlightId(flightid);
				return flightrepo.save(flight);
			} else {
				throw new NoSuchElementException(
						"Not Updated, No flights found for the given flightid, Search with valid flight ID");
			}

		} else {
			throw new RecordNotFoundException(
					"Not Updated, No flights found for the given flightid, Search with valid flight ID");

		}

	}

	public List<Flight> getFlights(String from, String to, LocalDate date1) {

		return flightrepo.findByInput(from, to, date1);

	}

	public Flight getFlight(int flightid) throws NullPointerException, SQLException, RecordNotFoundException {
		Optional<Flight> flightOptional = flightrepo.findById(flightid);
		if (flightOptional.isPresent()) {
			return flightOptional.get();
		} else {
			throw new RecordNotFoundException("No flights found for the given flightid, Search with valid flight ID");

		}
	}

	public void updateFlightDataAfterBooking(Flight flight, int flightid) throws SQLException {

		if (flightrepo.existsById(flightid)) {
			flightrepo.save(flight);
		}

	}

	public KafkaTemplate<String, String> getKafkaTemplate() {
		return kafkaTemplate;
	}

	public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

}
