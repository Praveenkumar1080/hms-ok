package com.cg.hms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hms.entities.Physician;

@Service
public interface PhysicianService {
	
	
	public Physician savePhysician(Physician physician);
	public Physician getPhysicianDetailsByName(String name);
	public List<Physician>  getallPhysiciansByPositions(String position);
	public Physician  getPhysicianByEmpid(Integer employeeid);
	public Physician updatePositionOfPhysician(Integer employeeid,Physician physician);
	public Physician updateNameOfPhysician(Integer employeeid,Physician physician);
	public Physician updateSSNOfPhysician(Integer employeeid,Physician physician);

	
	
	
	

}
