package com.cg.hms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Patient;
import com.cg.hms.entities.Physician;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
public List<Patient> findByPcp(Physician physician);
}
