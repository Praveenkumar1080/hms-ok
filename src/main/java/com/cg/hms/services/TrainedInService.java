package com.cg.hms.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hms.entities.Physician;
import com.cg.hms.entities.Procedures;
import com.cg.hms.entities.TrainedIn;

@Service
public interface TrainedInService {
	
	public void saveCertification(TrainedIn certification);
	public void getCertification(int physicianId, int treatmentId, LocalDateTime certificationDate, LocalDateTime certificationExpires); 
	public List<Procedures> getProceduresWithCertification();
	public List<Procedures> getTreatmentsByPhysicianId(int physicianId);
	public List<Physician> getPhysiciansByTreatmentId(int treatmentId);
	public List<Procedures> getProceduresWithExpiringCertification();
	boolean updateCertificationExpiryDate(int physicianId, int procedureId, TrainedIn obj);
	

}
