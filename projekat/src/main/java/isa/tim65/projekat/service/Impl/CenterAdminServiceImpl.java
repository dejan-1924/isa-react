package isa.tim65.projekat.service.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isa.tim65.projekat.model.Center;
import isa.tim65.projekat.model.CenterAdmin;
import isa.tim65.projekat.model.DTO.CenterAdminDTO;
import isa.tim65.projekat.repository.CenterAdminRepository;
import isa.tim65.projekat.repository.CenterRepository;
import isa.tim65.projekat.service.CenterAdminService;

@Service
public class CenterAdminServiceImpl implements CenterAdminService {
	@Autowired
	private CenterRepository centerRepo;
	
	@Autowired
	private CenterAdminRepository centerAdminRepo;
	
	@Override
	public CenterAdminDTO registerCenterAdmin(CenterAdminDTO centerAdmin) {
		Center center = centerRepo.findById(centerAdmin.getCenterId()).orElse(null);
		Set<CenterAdmin> centerAdmins = center.getCenterAdmins();
		boolean isMale = centerAdmin.getGender().equalsIgnoreCase("male") ? true : false;
		
		CenterAdmin admin = new CenterAdmin(centerAdmin.getEmail(), centerAdmin.getPassword(), centerAdmin.getName(), centerAdmin.getSurname(),
				centerAdmin.getAddress(), centerAdmin.getCity(), centerAdmin.getCountry(), centerAdmin.getPhoneNumber(),
				centerAdmin.getSsn(), isMale, center);
		
		centerAdminRepo.save(admin);
		centerAdmins.add(admin);
		centerRepo.save(center);
		
		return centerAdmin;
	}

}
