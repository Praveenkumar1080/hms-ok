package com.cg.hms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hms.entities.Nurse;

@Service
public interface NurseService {
	
	public Nurse saveNurse(Nurse nurse);
	public List<Nurse> getallNurses();
	public Nurse getDetailOfNurseByemployeeId(Integer employeeid);
	public String getPositionOfNurseByemployeeId(Integer id);
	public Boolean NurseIsRegisteredOrNot(Integer id);
	public Nurse updateValueOfregistred(Integer employeeid, Nurse nurse);
	public Nurse updateValueOfSSN(Integer ssn, Nurse nurse);
	

}
