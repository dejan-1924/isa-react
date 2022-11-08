package isa.tim65.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import isa.tim65.projekat.model.CenterAdmin;
import isa.tim65.projekat.model.DTO.CenterAdminDTO;
import isa.tim65.projekat.service.CenterAdminService;

@Controller
@CrossOrigin(origins = "*")
@Transactional
@RequestMapping(value = "api/centerAdmin")
public class CenterAdminController {

	@Autowired
	private CenterAdminService centerAdminService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/registration")
	public ResponseEntity<CenterAdminDTO> registerCenterAdmin(@RequestBody CenterAdminDTO centerAdminDTO) {
		System.out.println(centerAdminDTO);
		return new ResponseEntity<>(centerAdminService.registerCenterAdmin(centerAdminDTO), HttpStatus.OK);
	}
}
