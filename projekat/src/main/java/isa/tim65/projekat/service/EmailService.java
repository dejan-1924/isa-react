package isa.tim65.projekat.service;

import org.springframework.mail.MailException;

import isa.tim65.projekat.model.DTO.LoginDTO;

public interface EmailService {
	public void sendDonorVerificationEmail(String email, String name, String ssn) throws MailException, InterruptedException;
}
