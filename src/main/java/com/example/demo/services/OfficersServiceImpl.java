package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domains.HISOfficer;
import com.example.demo.entities.HISOfficerEntity;
import com.example.demo.repositories.HISOfficerRepository;
import com.example.demo.utils.PasswordGeneration;

@Service
public class OfficersServiceImpl implements OfficersService {
	
	@Autowired
	HISOfficerRepository userRepo;
	@Autowired
	PasswordGeneration passGen;

	@Override
	public List<HISOfficer> viewAllOfficers() {
		List<HISOfficerEntity> officerEntity = userRepo.findAll();
		List<HISOfficer> officers;
		officers = officerEntity.stream().map(entity->{
			HISOfficer officer = new HISOfficer();
			BeanUtils.copyProperties(entity, officer);		
			return officer;
		}).collect(Collectors.toList());
		return officers;
	}

	@Override
	public HISOfficer addOfficer(HISOfficer officer) {
		if(officer.getOfficerId()==null) {
			//generating random password
			officer.setPassword(passGen.getRandomPassword(15));
			//setting active status
			officer.setActiveStatus(0);
			//setting LOCK status
			officer.setLockStatus(0);
		}
		HISOfficerEntity officerEntity = new HISOfficerEntity();
		BeanUtils.copyProperties(officer, officerEntity);
		HISOfficerEntity savedEntity = userRepo.save(officerEntity);
		BeanUtils.copyProperties(savedEntity, officer);
//		if(savedEntity.getUserId()!=null && savedEntity.getActiveStatus().equals("LOCKED")) {
//			return mailSender.infoSendMail(user);
//		}
		return officer;
	}

	@Override
	public HISOfficer viewOfficer(String email) {
		HISOfficerEntity officerEntity = userRepo.findByEmail(email);
		HISOfficer officer = new HISOfficer();
		BeanUtils.copyProperties(officerEntity, officer);
		return officer;
	}

	

//	@Override
//	public void inactiveOfficer() {
//		
//		
//	}
//
//	@Override
//	public HISOfficer viewOfficer() {
//		
//		return null;
//	}

	

}
