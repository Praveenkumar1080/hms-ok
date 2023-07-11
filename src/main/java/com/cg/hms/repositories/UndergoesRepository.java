package com.cg.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Undergoes;
import com.cg.hms.entities.UndergoesId;

@Repository
public interface UndergoesRepository extends JpaRepository<Undergoes,UndergoesId>{

}
