package com.cg.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer>{

}
