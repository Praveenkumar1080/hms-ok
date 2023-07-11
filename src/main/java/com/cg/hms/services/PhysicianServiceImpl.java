package com.cg.hms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entities.Physician;
import com.cg.hms.exceptions.DuplicateEntryException;
import com.cg.hms.exceptions.NoRecordsException;
import com.cg.hms.exceptions.NoSuchElementException;
import com.cg.hms.repositories.PhysicianRepository;

@Service
public class PhysicianServiceImpl implements PhysicianService  {
	
	private PhysicianRepository physicianRepository;
	
	@Autowired
	public void setPhysicianRepository(PhysicianRepository physicianRepository) {
		this.physicianRepository = physicianRepository;
	}

	@Override
	public Physician savePhysician(Physician physician) {
		if(physicianRepository.findById(physician.getEmployeeId()).isEmpty())
		  return physicianRepository.save(physician);
		throw new DuplicateEntryException("Trying to insert duplicate record");
	}

	@Override
	public Physician getPhysicianDetailsByName(String name) {
		
		return physicianRepository.findByName(name).orElseThrow(()-> new NoSuchElementException("not found"));
	}

	@Override
	public List<Physician> getallPhysiciansByPositions(String position) {
		
		List<Physician> physicians = physicianRepository.findByPosition(position);
		if(physicians.isEmpty())
		 throw new NoRecordsException("");
		return physicians;
	}

	@Override
	public Physician getPhysicianByEmpid(Integer employeeid) {
		
		return physicianRepository.findById(employeeid).orElseThrow(()-> new NoSuchElementException(""));
	}

	@Override
	public Physician updatePositionOfPhysician(Integer employeeid,Physician physician) {
		Physician obj=physicianRepository.findById(employeeid).orElseThrow(() -> new NoSuchElementException("physician not found with employeeid:" + employeeid));
		obj.setPosition(physician.getPosition());
		return physicianRepository.save(obj);
		
	}

	@Override
	public Physician updateNameOfPhysician(Integer employeeid, Physician physician) {
		Physician physician1=physicianRepository.findById(employeeid).orElseThrow(() -> new NoSuchElementException("physician not found with employeeid:" + employeeid));
		physician1.setName(physician.getName());
		return physicianRepository.save(physician1);
		
	}

	@Override
	public Physician updateSSNOfPhysician(Integer employeeid,Physician physician) {
		Physician physician1=physicianRepository.findById(employeeid).orElseThrow(() -> new NoSuchElementException("physician not found with employeeid:" + employeeid));
		physician1.setSsn(physician.getSsn());
		return physicianRepository.save(physician1);
	}
	
	

}
