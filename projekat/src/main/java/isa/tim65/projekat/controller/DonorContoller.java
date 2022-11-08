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
import org.springframework.web.bind.annotation.RequestMethod;

import isa.tim65.projekat.model.Donor;
import isa.tim65.projekat.model.DTO.DonorDTO;

import isa.tim65.projekat.model.DTO.LoginDTO;


import isa.tim65.projekat.service.DonorService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/profile")
public class DonorContoller {

	@Autowired
	private DonorService donorService;
	
	private int i = 0;
	


	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DonorDTO> get(@RequestBody String email) {
		DonorDTO donor = this.donorService.findByEmail("donor1@gmail.com");
		
		
	
		return new ResponseEntity<>(donor,HttpStatus.OK);
  }

	@CrossOrigin(origins = "*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/test")
	public ResponseEntity<String> test() {
		System.out.println(++i + ". Pogodio kontroler");
		return new ResponseEntity<>("Uspesno vratio vrednost 123", HttpStatus.OK);
	}

	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/findAllByFullName")
	public ResponseEntity<List<Donor>> findAllByFullName(@RequestBody DonorDTO donorDTO) {
		return new ResponseEntity<>(donorService.findAllByFullName(donorDTO.getName(), donorDTO.getSurname()), HttpStatus.OK);
	}


	
	 @RequestMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE, method= {RequestMethod.PUT})
	    public ResponseEntity<DonorDTO> updateClan(@RequestBody DonorDTO d) throws Exception {

		 DonorDTO updated = donorService.update(d);
		 System.out.println(updated.getCity());
	        
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }
	
	
}
