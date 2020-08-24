package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.HISOfficer;
import com.example.demo.services.OfficersServiceImpl;

@RestController
@CrossOrigin(origins="*")
public class ViewOfficersController {
	
	@Autowired
	OfficersServiceImpl service;
	
	@GetMapping("/view-officers")
	public List<HISOfficer> getAllOfficers(){
		List<HISOfficer> officers = service.viewAllOfficers();
		return officers;
	}

}
