package com.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.sendmail.domain.User;
import com.sendmail.service.NotificationService;

@SpringBootApplication
@EnableAsync
public class SendingEmailAsyncApplication implements CommandLineRunner {

	@Autowired
	private NotificationService notificationService;
	
	public static void main(String[] args) {
		SpringApplication.run(SendingEmailAsyncApplication.class, args);
	}

	@Override
	public void run(String...args) {
		sendMail();
	}

	public void sendMail(){
		
		// create user 
		User user = new User();
		user.setFirstName("Dan");
		user.setLastName("Vega");
		user.setEmailAddress("dan@clecares.org");
		
		// send a notification
		try {
			notificationService.sendMail(user);
		}catch( Exception e ){
			// catch error
			System.out.println("Error Sending Email: " + e.getMessage());
		}
		
	}

}
