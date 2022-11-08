package isa.tim65.projekat.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import isa.tim65.projekat.model.DTO.LoginDTO;
import isa.tim65.projekat.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;

	@Async
	public void sendDonorVerificationEmail(String email, String name, String ssn) throws MailException, InterruptedException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Email Validation for ISA Project");
		mail.setText("Hi, " + name + ",\n\nVerify your account by clicking link:\n\n" + 
		"\thttp://localhost:" + env.getProperty("server.port") + "/api/registration/verify/" + ssn /* "/api/registration/test"*/);
		javaMailSender.send(mail);

	}
}
