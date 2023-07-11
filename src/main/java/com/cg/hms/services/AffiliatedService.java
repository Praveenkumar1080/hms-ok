package com.cg.hms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hms.entities.Affiliatedwith;
import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;

@Service
public interface AffiliatedService {

	public void saveAffiliatedwith(int id);
	public List<Physician> getPhysiciansByDepartment(int departmentId);
	public List<Department> getDepartmentsByPhysician(Integer physicianId);
	public Integer countPhysiciansByDepartment(Integer departmentId);
	public Boolean getPrimaryAffiliation(Integer physicianId);
	public Boolean updatePrimaryAffiliation(Integer id,Affiliatedwith pff);
	
	
	
	
	
}
