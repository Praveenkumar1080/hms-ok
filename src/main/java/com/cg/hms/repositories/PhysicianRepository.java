package com.cg.hms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Physician;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician, Integer> {

	
	@Query(value="SELECT * FROM Physician p WHERE p.name=?1",nativeQuery=true)
	Optional<Physician> findByName(String name);

	List<Physician> findByPosition(String position);
}
