package com.cg.hms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Physician;
import com.cg.hms.entities.Procedures;
import com.cg.hms.entities.TrainedId;
import com.cg.hms.entities.TrainedIn;


@Repository
public interface TrainedInRepository extends JpaRepository<TrainedIn, TrainedId>{

	public List<TrainedIn> findByPhysician(Physician phy);

	public List<TrainedIn> findByTreatment(Procedures phy);
	
	

}
