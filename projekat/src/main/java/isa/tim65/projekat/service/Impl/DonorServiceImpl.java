package isa.tim65.projekat.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.tim65.projekat.model.CenterAdmin;
import isa.tim65.projekat.model.Donor;
import isa.tim65.projekat.model.SystemAdmin;
import isa.tim65.projekat.model.DTO.DonorDTO;
import isa.tim65.projekat.model.DTO.RetValDTO;
import isa.tim65.projekat.repository.CenterAdminRepository;
import isa.tim65.projekat.repository.DonorRepository;
import isa.tim65.projekat.repository.SystemAdminRepository;
import isa.tim65.projekat.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService {
	
	@Autowired
	private DonorRepository donorRepo;
	
	@Autowired
	private CenterAdminRepository caRepo;
	
	@Autowired
	private SystemAdminRepository saRepo;
	
	public Donor findOne(Integer id) {
		return donorRepo.findById(id).orElseGet(null);
	}

	public List<Donor> findAll() {
		return donorRepo.findAll();
	}


	public DonorDTO findByEmail(String email) {
		List<Donor> donors = this.donorRepo.findAll();
		for(Donor donor : donors) {
			if(donor.getEmail().equals(email)) {
				return  new DonorDTO(donor.getId(),donor.getEmail(),donor.getPassword(),
						donor.getName(),donor.getSurname(), donor.getAddress(),donor.getCity(), donor.getCountry(), 
						donor.getPhoneNumber(), donor.getSsn(), donor.isMale(), donor.getProfession(), 
						donor.getInstitution());
			}

	}
		return null;
}
	
	public List<Donor> findAllByFullName(String firstName, String lastName) {
		List<Donor> ret = new ArrayList<>();
		List<Donor> donors = donorRepo.findAll();
		for(Donor d : donors) {
			if(d.getName().equalsIgnoreCase(firstName) && d.getSurname().equalsIgnoreCase(lastName))
				ret.add(d);
		}
		return ret;
	}
	
	public Donor save(Donor donor) {
		return donorRepo.save(donor);
	}

	public void remove(Integer id) {
		donorRepo.deleteById(id);
	}
	public RetValDTO registration(DonorDTO donorDTO) {
		List<Donor> donors = this.donorRepo.findAll();
		for(Donor d : donors) {
			if(d.getEmail().equals(donorDTO.getEmail())) {
				return new RetValDTO(false, "Email is already in use!");
			}
			if(d.getSsn().equals(donorDTO.getSsn())) {
				return new RetValDTO(false, "Person with this Social Security Number is already registred!");
			}
			if(d.getPhoneNumber().equals(donorDTO.getPhoneNumber())) {
				return new RetValDTO(false, "Person with this Phone Number is already registred!");
			}
		}
		List<SystemAdmin> sas = this.saRepo.findAll();
		for(SystemAdmin sa : sas) {
			if(sa.getEmail().equals(donorDTO.getEmail())) {
				return new RetValDTO(false, "Email is already in use!");
			}
			if(sa.getSsn().equals(donorDTO.getSsn())) {
				return new RetValDTO(false, "Person with this Social Security Number is already registred!");
			}
			if(sa.getPhoneNumber().equals(donorDTO.getPhoneNumber())) {
				return new RetValDTO(false, "Person with this Phone Number is already registred!");
			}
		}
		List<CenterAdmin> cas = this.caRepo.findAll();
		for(CenterAdmin ca : cas) {
			if(ca.getEmail().equals(donorDTO.getEmail())) {
				return new RetValDTO(false, "Email is already in use!");
			}
			if(ca.getSsn().equals(donorDTO.getSsn())) {
				return new RetValDTO(false, "Person with this Social Security Number is already registred!");
			}
			if(ca.getPhoneNumber().equals(donorDTO.getPhoneNumber())) {
				return new RetValDTO(false, "Person with this Phone Number is already registred!");
			}
		}
		Donor newDonor = new Donor();
		newDonor.setEmail(donorDTO.getEmail());
		newDonor.setPassword(donorDTO.getPassword());
		newDonor.setName(donorDTO.getName());
		newDonor.setSurname(donorDTO.getSurname());
		newDonor.setAddress(donorDTO.getAddress());
		newDonor.setCity(donorDTO.getCity());
		newDonor.setCountry(donorDTO.getCountry());
		newDonor.setPhoneNumber(donorDTO.getPhoneNumber());
		newDonor.setSsn(donorDTO.getSsn());
		newDonor.setMale(donorDTO.isMale());
		newDonor.setProfession("");
		newDonor.setInstitution("");
		newDonor.setLoyaltyGroup("");
		newDonor.setLoyaltyPoints(0);
		this.donorRepo.save(newDonor);
		return new RetValDTO(true, "Registration was succesful!");
	}
	public void verify(String ssn) {
		List<Donor> donors = this.donorRepo.findAll();
		for(Donor d : donors) {
			if(d.getSsn().equals(ssn)) {
				d.setValidated(true);
				donorRepo.save(d);
			}
		}
	}
	
	public DonorDTO update(DonorDTO donor) {
		
		List<Donor> donors = this.donorRepo.findAll();
		int donorForUpdateId = -1;
		for(Donor d : donors) {
			if(d.getSsn().equals(donor.getSsn())) {
				d.setAddress(donor.getAddress());
				d.setName(donor.getName());
				d.setSurname(donor.getSurname());
				d.setCity(donor.getCity());
				d.setCountry(donor.getCountry());
				d.setProfession(donor.getProfession());
				d.setInstitution(donor.getInstitution());
				donorRepo.save(d);
				donorForUpdateId = d.getId();
			}
		
		}
		return donor;
		
	}
	
	
}
