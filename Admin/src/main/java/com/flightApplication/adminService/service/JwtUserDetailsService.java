package com.flightApplication.adminService.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightApplication.adminService.entity.Admin;
import com.flightApplication.adminService.repository.AdminRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {

    // entity -> user
    // repo.findById
	@Autowired
	AdminRepository adminrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admin a = adminrepo.getById(username);
		if (a.getUserId().equals(username)) {

            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));

			// return new User("admin", "{noop}hello@world",new ArrayList<>());
			// return new User("admin", "{bcrypt}$2a$10$Dwzu0xQK7eHkBMA67KjPpelsTuvajmYArw5ruHxWvSgboxmAjp9mu", new ArrayList<>());
			return new User("admin", "$2a$10$er4/qfJYKmDClcq2PyjK7.Caw3x8poocWQYUpH1oe//I02Yg4rqdG", authorities);
		} else if (a.getUserId().equals(username)) {

            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));

			return new User("user", "$2a$10$Dwzu0xQK7eHkBMA67KjPpelsTuvajmYArw5ruHxWvSgboxmAjp9mu", authorities);
		}
        
        else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}