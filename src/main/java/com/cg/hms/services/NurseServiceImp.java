package com.cg.hms.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entities.Nurse;
import com.cg.hms.exceptions.DuplicateEntryException;
import com.cg.hms.exceptions.NoRecordsException;
import com.cg.hms.exceptions.NoSuchElementException;
import com.cg.hms.repositories.NurseRepository;
@Service
public class NurseServiceImp implements NurseService {

    private NurseRepository nurseRepository;

    @Autowired
    public void setNurseRepository(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

 

    @Override
    public Nurse saveNurse(Nurse nurse) {
    	 if(nurseRepository.findById(nurse.getEmployeeId()).isEmpty())
    	    return nurseRepository.save(nurse);
    	 throw new DuplicateEntryException("");
         
    }

 

    @Override
    public List<Nurse> getallNurses() {
         List<Nurse> nurse = nurseRepository.findAll();
         if(nurse.isEmpty())
            throw new NoRecordsException("");
         return nurse;

    }

 

    @Override
    public Nurse getDetailOfNurseByemployeeId(Integer employeeid) {
        return nurseRepository.findById(employeeid).orElseThrow(()-> new NoSuchElementException(""));
    }

 

    @Override
    public String getPositionOfNurseByemployeeId(Integer employeeid) {
        return nurseRepository.findById(employeeid).orElseThrow(()-> new NoSuchElementException("")).getPosition();
    }


 

    @Override
    public Boolean NurseIsRegisteredOrNot(Integer employeeid) {
         return nurseRepository.findById(employeeid).orElseThrow(()-> new NoSuchElementException("")).isRegistered();
    }

 

    @Override
    public Nurse updateValueOfregistred(Integer employeeid, Nurse nur) {
         Nurse nurse = nurseRepository.findById(employeeid).orElseThrow(()-> new NoSuchElementException(""));
         nurse.setRegistered(nur.isRegistered());
         return nurseRepository.save(nurse);
        }
    @Override
    public Nurse updateValueOfSSN(Integer employeeid, Nurse nur) {
         Nurse nurse = nurseRepository.findById(employeeid).orElseThrow(()-> new NoSuchElementException(""));
         nurse.setSsn(nur.getSsn());
         return nurseRepository.save(nurse);
            
        }
    }
