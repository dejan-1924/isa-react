package isa.tim65.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.tim65.projekat.model.DTO.LoginDTO;
import isa.tim65.projekat.service.LoginService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO) {
		 LoginDTO retVal = loginService.checkLogIn(loginDTO);
		 System.out.println("Email: " + retVal.getEmail() + "\t Password: " + retVal.getPassword() + "\t Success: " + (retVal.getRole().equals("unauthorized") ? "NO" : "YES").toString());
	     return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
}
