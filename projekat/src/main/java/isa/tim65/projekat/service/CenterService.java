package isa.tim65.projekat.service;

import java.util.List;

import isa.tim65.projekat.model.Center;
import isa.tim65.projekat.model.DTO.CenterDTO;

public interface CenterService {
	
	public Center findOne(Integer id);
	
	public List<Center> findAll();
	
	public List<CenterDTO> getDTOs();
	
	public Center register(CenterDTO centerDTO);
	
	public Center save(Center center);
	
	public void remove(Integer id);
	
}
