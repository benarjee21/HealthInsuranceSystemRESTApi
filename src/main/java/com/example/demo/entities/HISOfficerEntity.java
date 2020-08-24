package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="his_officers")
public class HISOfficerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="officer_id")
	private Integer officerId;
	
	@Column(name="officer_fname")
	private String fName;
	
	@Column(name="officer_lname")
	private String lName;
	
	@Column(name="officer_email")
	private String email;
	
	@Column(name="officer_phno")
	private String phoneNo;
	
	@Column(name="officer_role")
	private String role;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="officer_dob")
	private Date dob;
	
	@Column(name="active_status")
	private int activeStatus;
	
	@Column(name="lock_status")
	private int lockStatus;
	
	@Column(name="password")
	private String password;
		
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="created_date",updatable=false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="updated_date",insertable=false)
	private Date updatedDate;

}
