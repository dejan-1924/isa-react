package isa.tim65.projekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.tim65.projekat.model.Center;
import isa.tim65.projekat.model.DTO.CenterDTO;
import isa.tim65.projekat.service.CenterService;

@Controller
@RequestMapping(value = "api/center")
public class CenterController {
	
	@Autowired
	private CenterService centerService;
	
	@CrossOrigin(origins = "*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/centers")
	public ResponseEntity<List<CenterDTO>> getAll() {
		return new ResponseEntity<>(centerService.getDTOs(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE, value = "/registration")
	public ResponseEntity<Center> register(@RequestBody CenterDTO centerDTO) {
		System.out.println("Pogodio kontroler\n");
		System.out.println("Ime centra je: " + centerDTO.getName());
		System.out.println("Adresa centra je: " + centerDTO.getAddress());
		return new ResponseEntity<>(centerService.register(centerDTO), HttpStatus.OK);
	}
}
