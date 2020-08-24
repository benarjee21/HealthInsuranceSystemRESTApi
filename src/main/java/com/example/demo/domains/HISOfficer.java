package com.example.demo.domains;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HISOfficer {
	
	private Integer officerId;
	private String fName;
	private String lName;
	private String email;
	private String phoneNo;
	private String role;
	private char gender ;
	private Date dob;
	private int activeStatus;
	private int lockStatus;
	private String password;
//	private Date createdDate;
//	private Date updatedDate;

}
