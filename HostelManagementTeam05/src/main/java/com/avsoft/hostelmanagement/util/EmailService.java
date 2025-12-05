package com.avsoft.hostelmanagement.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Value("${email_service}")
	private String emailService;

	public String emailServive(String toEmail, String subject, String msg) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(toEmail);
		mailMessage.setFrom(emailService);
		mailMessage.setSubject(subject);
		mailMessage.setText(msg);

		javaMailSender.send(mailMessage);

		return MessageConstant.MASSEGE_SENDER;
	}
	
	
	// mail servicce - Otp sending 
	
	public void sendOtp(String toEmail, String otp) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Hostel Signup Verification OTP");
		message.setText("Your OTP is : " + otp + "\n(It is valid for 10 minutes.)");

		javaMailSender.send(message);
	
	
	
	}
	
	
}
