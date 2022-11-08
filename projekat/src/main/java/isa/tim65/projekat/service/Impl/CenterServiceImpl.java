package isa.tim65.projekat.service.Impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.tim65.projekat.model.Appointment;
import isa.tim65.projekat.model.Center;
import isa.tim65.projekat.model.CenterAdmin;
import isa.tim65.projekat.model.DTO.CenterDTO;
import isa.tim65.projekat.repository.CenterAdminRepository;
import isa.tim65.projekat.repository.CenterRepository;
import isa.tim65.projekat.service.CenterService;

@Service
public class CenterServiceImpl implements CenterService{

	@Autowired
	private CenterRepository centerRepo;
	
	public Center findOne(Integer id) {
		return centerRepo.findById(id).orElseGet(null);
	}

	public List<Center> findAll() {
		return centerRepo.findAll();
	}
	
	public List<CenterDTO> getDTOs() {
		List<CenterDTO> retList = new ArrayList<>();
		List<Center> rawList = centerRepo.findAll();
		for(Center c : rawList) {
			retList.add(new CenterDTO(c.getId(), c.getName(), c.getAddress(), c.getCity(), c.getCountry(),
					c.getDescription(), c.getOpening(), c.getClosing(), c.getGrade()));
		}
		return retList;
	}

	public Center save(Center centar) {
		return centerRepo.save(centar);
	}

	public void remove(Integer id) {
		centerRepo.deleteById(id);
	}

	@Override
	public Center register(CenterDTO centerDTO) {
		
		Center c = new Center(centerDTO.getName(), centerDTO.getAddress(), centerDTO.getCity(), centerDTO.getCountry(), centerDTO.getDescription(), 
				centerDTO.getOpening(), centerDTO.getClosing(), (float) 0.0, null, null);
		centerRepo.save(c);
		
		return c;
	}
	
}
