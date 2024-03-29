package com.sendmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sendmail.domain.User;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	@Async
	public void sendMail(User user) throws MailException, InterruptedException {
		
        System.out.println("Sleeping now...");
        Thread.sleep(1000);
		
        System.out.println("Sending email...");
        
        SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setCc("ps1@mail.com,ps2@mail.com,ps3@mail.com,ps4@mail.com,ps5@mail.com,".split(","));
		mail.setFrom("danvega@gmail.com");
		mail.setSubject("Spring Boot is awesome!");
		mail.setText("Why aren't you using Spring Boot?");
		javaMailSender.send(mail);
		
		System.out.println("Email Sent!");
	}
	
}