package com.cg.hms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Patient;
import com.cg.hms.entities.Stay;

@Repository
public interface StayRepository extends JpaRepository<Stay, Integer>{

	List<Stay> findByPatient(Patient patient);
	
}
