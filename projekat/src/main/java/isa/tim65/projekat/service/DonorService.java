package isa.tim65.projekat.service;

import java.util.List;

import isa.tim65.projekat.model.Donor;
import isa.tim65.projekat.model.DTO.DonorDTO;
import isa.tim65.projekat.model.DTO.RetValDTO;

public interface DonorService {
	
	public Donor findOne(Integer id);

	public DonorDTO findByEmail(String email);
	
	public List<Donor> findAll();
	
	public DonorDTO update(DonorDTO donor);

	public Donor save(Donor donor);

	public void remove(Integer id);
	
	public RetValDTO registration(DonorDTO donorDTO);
	
	public List<Donor> findAllByFullName(String firstName, String lastName);
	
	public void verify(String ssn);
}
