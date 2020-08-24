package com.example.demo.services;

import java.util.List;

import com.example.demo.domains.HISOfficer;

public interface OfficersService {
	
	public List<HISOfficer> viewAllOfficers();
	public HISOfficer addOfficer(HISOfficer officer);
	public HISOfficer viewOfficer(String email);
//	public void inactiveOfficer();
//	public HISOfficer viewOfficer();

}
