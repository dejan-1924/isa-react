package isa.tim65.projekat.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.tim65.projekat.model.DTO.DonorDTO;
import isa.tim65.projekat.model.DTO.RetValDTO;
import isa.tim65.projekat.service.DonorService;
import isa.tim65.projekat.service.EmailService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/registration")
public class RegistrationController {

	@Autowired
	private DonorService donorService;
	@Autowired
	private EmailService emailService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE, value="/donor")
	public ResponseEntity<RetValDTO> donorRegistration(@RequestBody DonorDTO donorDTO) {
		RetValDTO retVal = this.donorService.registration(donorDTO);
		//System.out.println(new Date());
		if(retVal.getIsSuccess())
			try {
				emailService.sendDonorVerificationEmail(donorDTO.getEmail(), donorDTO.getName() + " " + donorDTO.getSurname(), donorDTO.getSsn());
			}catch( Exception e ){
				System.out.println("Error sending mail!\n" + e.getMessage());
			}
		//System.out.println(new Date());
	    return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
        	value = "/verify/{ssn}")
	public ResponseEntity<String> verify(@PathVariable String ssn) {
		this.donorService.verify(ssn);
		return new ResponseEntity<>("Account verified, you can close this page now.", HttpStatus.OK);
	}
}
