package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.HISOfficer;
import com.example.demo.services.OfficersServiceImpl;

@RestController
@CrossOrigin(origins="*")
public class CreateOfficerController {
	
	@Autowired
	OfficersServiceImpl service;
	
	@PostMapping("/create-officer")
	public String getAllOfficers(@RequestBody HISOfficer officer){
		HISOfficer savedOfficer = service.addOfficer(officer);
		if(savedOfficer==null) {
			return "Failed";
		}
		return "Success";
	}
	
	@GetMapping("/get-officer/{email}")
	public String getAllOfficers(@PathVariable String email){
		HISOfficer savedOfficer = service.viewOfficer(email);
		if(savedOfficer==null) {
			return null;
		}
		return "Found";
	}

}
