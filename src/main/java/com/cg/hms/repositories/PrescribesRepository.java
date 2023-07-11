package com.cg.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Prescribes;

@Repository
public interface PrescribesRepository extends JpaRepository<Prescribes, Integer>{

}
