package isa.tim65.projekat.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.tim65.projekat.model.CenterAdmin;
import isa.tim65.projekat.model.Donor;
import isa.tim65.projekat.model.SystemAdmin;
import isa.tim65.projekat.model.DTO.LoginDTO;
import isa.tim65.projekat.repository.CenterAdminRepository;
import isa.tim65.projekat.repository.DonorRepository;
import isa.tim65.projekat.repository.SystemAdminRepository;
import isa.tim65.projekat.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private DonorRepository donorRepo;
	
	@Autowired
	private CenterAdminRepository caRepo;
	
	@Autowired
	private SystemAdminRepository saRepo;
	
	public LoginDTO checkLogIn(LoginDTO li) {
		LoginDTO retVal = li;
		retVal.setRole("unauthorized");
		List<Donor> donors = this.donorRepo.findAll();
		for(Donor d : donors){
			if(d.getEmail().equals(li.getEmail())) {
				if(d.getPassword().equals(li.getPassword())) {
					if(d.isValidated()) {
						retVal.setRole("donor");
						return retVal;
					} else {
						retVal.setRole("notValidated");
						return retVal;
					}
					
				} else {
					return retVal;
				}
				
			}
		}
		List<SystemAdmin> sas = this.saRepo.findAll();
		for(SystemAdmin s : sas){
			if(s.getEmail().equals(li.getEmail())) {
				if(s.getPassword().equals(li.getPassword())) {
					retVal.setRole("systemadmin");
					return retVal;
				} else {
					return retVal;
				}
			}
		}
		List<CenterAdmin> cas = this.caRepo.findAll();
		for(CenterAdmin c : cas){
			if(c.getEmail().equals(li.getEmail())) {
				if(c.getPassword().equals(li.getPassword())) {
					retVal.setRole("centeradmin");
					return retVal;
				} else {
					return retVal;
				}
			}
		}
		return retVal;
	}
}
