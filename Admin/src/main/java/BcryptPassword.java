

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class BcryptPassword {
	public static void main(String args [])
	{
		 PasswordEncoder encoder = new BCryptPasswordEncoder();
		 String encodedString = encoder.encode("training@cts");
		 System.out.println(encodedString);
	}
    
}