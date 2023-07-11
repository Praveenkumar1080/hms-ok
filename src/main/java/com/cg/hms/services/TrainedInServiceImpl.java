package com.cg.hms.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entities.Physician;
import com.cg.hms.entities.Procedures;
import com.cg.hms.entities.TrainedIn;
import com.cg.hms.repositories.PhysicianRepository;
import com.cg.hms.repositories.ProcedureRepository;
import com.cg.hms.repositories.TrainedInRepository;

@Service
public class TrainedInServiceImpl implements TrainedInService {
	
	private TrainedInRepository trainedinRepository;
	
	private PhysicianRepository phyrepo;
	
	private ProcedureRepository prorepo;
	@Autowired
	public void setTrainedinRepository(TrainedInRepository trainedinRepository) {
		this.trainedinRepository = trainedinRepository;
	}
	@Autowired
	public void setPhyRepo(PhysicianRepository phyrepo) {
		this.phyrepo = phyrepo;
	}
	@Autowired
	public void setProrepo(ProcedureRepository prorepo) {
		this.prorepo = prorepo;
	}

	/*@Override
	public List<Procedures> getProceduresWithCertification() {
		
		
	}*/

	@Override
	public List<Procedures> getTreatmentsByPhysicianId(int physicianId) {
		Physician phy = phyrepo.findById(physicianId).get();
		List<TrainedIn> list = trainedinRepository.findByPhysician(phy);
		List<Procedures> pro = new ArrayList<>();
		for(TrainedIn i:list) {
			pro.add(i.getTreatment());
		}
		return pro;
	}

	@Override
	public List<Physician> getPhysiciansByTreatmentId(int treatmentId) {
		Procedures phy = prorepo.findById(treatmentId).get();
		List<TrainedIn> list = trainedinRepository.findByTreatment(phy);
		List<Physician> pro = new ArrayList<>();
		for(TrainedIn i:list) {
			pro.add(i.getPhysician());
		}
		return pro;
		
	}

	/*@Override
	public List<Procedures> getProceduresWithExpiringCertification() {
		LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.plusMonths(1);
        return trainedinRepository.findProceduresWithCertificationExpiringWithin(expiryDate);
	}*/

	@Override
	public boolean updateCertificationExpiryDate(int physicianId, int procedureId, TrainedIn obj) {
		Physician phy = phyrepo.findById(physicianId).get();
		List<TrainedIn> list = trainedinRepository.findByPhysician(phy);
	    for(TrainedIn t:list) {
	    	if(t.getTreatment().getCode()==procedureId) {
	    		t.setCertificationExpires(obj.getCertificationExpires());
	    		break;
	    	}
	    }
	       return true;
	    }

	@Override
	public void saveCertification(TrainedIn certification) {
		trainedinRepository.save(certification);
		
	}

	@Override
	public void getCertification(int physicianId, int treatmentId, LocalDateTime certificationDate,
			LocalDateTime certificationExpires) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Procedures> getProceduresWithCertification() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Procedures> getProceduresWithExpiringCertification() {
		// TODO Auto-generated method stub
		return null;
	}
}
