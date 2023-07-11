package com.cg.hms.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entities.Affiliatedwith;
import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;
import com.cg.hms.exceptions.NoEntryException;
import com.cg.hms.exceptions.NoSuchElementException;
import com.cg.hms.repositories.AffiliatedwithRepository;
import com.cg.hms.repositories.PhysicianRepository;

@Service
public class AffiliatedServiceImpl implements AffiliatedService{
	
	private AffiliatedwithRepository affiliatedwithRepository;
	private PhysicianRepository physicianRepository;
	
	@Autowired
	public void physicianService(PhysicianRepository physicianRepository, AffiliatedwithRepository affiliatedwithRepository) {
		this.physicianRepository=physicianRepository;
		this.affiliatedwithRepository=affiliatedwithRepository;
	}
	
	@Override
	public void saveAffiliatedwith(int id) {
		Affiliatedwith object = new Affiliatedwith();
		Physician physician = physicianRepository.findById(id).orElseThrow(()-> new NoSuchElementException("physician with given id not found"));
		object.setPhysician(physician);
		affiliatedwithRepository.save(object);	
	}

	@Override
	public List<Physician> getPhysiciansByDepartment(int departmentId) {
		List<Physician> physicians = affiliatedwithRepository.findByDepId(departmentId);
		if(physicians.isEmpty())
			throw new NoEntryException("");
		return physicians;
		
	}

	@Override
	public List<Department> getDepartmentsByPhysician(Integer physicianId) {
		List<Affiliatedwith> affiliations = affiliatedwithRepository.findByPhysician(physicianId);
		if(affiliations.isEmpty())
		  throw new NoEntryException("no record in the table for given physician");
		return affiliations.stream().map(x->x.getDepartment()).collect(Collectors.toList());
	}

	@Override
	public Integer countPhysiciansByDepartment(Integer departmentId) {
		return affiliatedwithRepository.countByDepartment(departmentId);
	}

	@Override
	public Boolean getPrimaryAffiliation(Integer physicianId) {
		List<Affiliatedwith> p = affiliatedwithRepository.findByPhysician(physicianId);
		if(p.isEmpty())
		 throw new NoEntryException("no record in the table for given physician");
	    return p.stream().anyMatch(a-> a.getPrimaryAffiliation());
}
	@Override
	public Boolean updatePrimaryAffiliation(Integer physicianid,Affiliatedwith pff) {
	List<Affiliatedwith> affiliations = affiliatedwithRepository.findByPhysician(physicianid);
	if(affiliations.isEmpty())
	 throw new NoEntryException("no record in the table for given physician");
	affiliations.stream().filter(a-> a.getPrimaryAffiliation()).forEach((a)-> a.setPrimaryAffiliation(pff.getPrimaryAffiliation()));
	return true;
		
	}
	
	

}
