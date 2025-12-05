package com.avsoft.hostelmanagement.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

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
}
