package com.cg.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer>{

}
