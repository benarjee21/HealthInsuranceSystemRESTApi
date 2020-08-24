package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.HISOfficerEntity;

@Repository
public interface HISOfficerRepository extends JpaRepository<HISOfficerEntity,Integer> {
	
	public HISOfficerEntity findByEmail(String email);

}
