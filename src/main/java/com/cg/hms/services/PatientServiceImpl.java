
  package com.cg.hms.services;
  
  import java.util.List; import java.util.Optional;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;

import com.cg.hms.entities.Patient;
import com.cg.hms.entities.Physician;
import com.cg.hms.exceptions.DuplicateEntryException;
import com.cg.hms.exceptions.NoEntryException;
import com.cg.hms.exceptions.NoRecordsException;
import com.cg.hms.exceptions.NoSuchElementException;
import com.cg.hms.repositories.PatientRepository;
import com.cg.hms.repositories.PhysicianRepository;
  @Service
  public class PatientServiceImpl implements PatientService{
  
  private PatientRepository patientRepository;
  
  private PhysicianRepository physicianRepository;
  
  @Autowired 
  public void setPatientRepository(PatientRepository patientRepository) {
  this.patientRepository = patientRepository;
  }
  
  @Autowired 
  public void setphysicianRepository(PhysicianRepository physicianRepository){
  this.physicianRepository = physicianRepository;
  }
  
  @Override 
  public Patient addPatientReport(Patient patient) {
	  if(patientRepository.findById(patient.getSsn()).isEmpty())
		  return patientRepository.save(patient);
	  throw new DuplicateEntryException("");
	  
	  }
  
  @Override
  public List<Patient> getallPatients() {
 
  List<Patient> patients = patientRepository.findAll();
  if(patients.isEmpty())
    throw new NoRecordsException("");
  return patients;
  }
  
  @Override
  public List<Patient> getParticularPhysicians(Integer physicianid) {
  Physician phy = physicianRepository.findById(physicianid).orElseThrow(()-> new NoSuchElementException(""));
  List<Patient> patients = patientRepository.findByPcp(phy);
  if(patients.isEmpty())
   throw new NoEntryException("");
  return patients;
  }
  
  @Override 
  public Patient getParticularPatient(Integer physicianid,Integer patientid) {
  Physician phy = physicianRepository.findById(physicianid).orElseThrow(()-> new NoSuchElementException(""));
  List<Patient> lis = patientRepository.findByPcp(phy);
  Patient patien = patientRepository.findById(patientid).orElseThrow(()-> new NoSuchElementException(""));
  Optional<Patient> patient = lis.stream().filter(x -> x.equals(patien)).findFirst();
  return patient.orElseThrow(()-> new NoSuchElementException(""));
  }
  
  @Override
  public Integer getInsuranceOfPatient(Integer patientid) {
  return patientRepository.findById(patientid).orElseThrow(()-> new NoSuchElementException("")).getInsuranceId();
  }
  
  
  @Override
  public Patient updateAddressOfPatient(Integer ssn,Patient patient)
  {
  Patient patient1 = patientRepository.findById(ssn).orElseThrow(()-> new NoSuchElementException(""));
  patient1.setAddress(patient.getAddress());
  return patientRepository.save(patient1);
  }
  @Override public Patient updatePhoneOfPatient(Integer ssn,Patient patient) {
  Patient patient1 = patientRepository.findById(ssn).orElseThrow(()-> new NoSuchElementException(""));
  patient1.setPhone(patient.getPhone());
  return patientRepository.save(patient1);
  
  }
  }
  
  
  
 