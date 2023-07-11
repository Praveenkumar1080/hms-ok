
  package com.cg.hms.controllers;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RequestMethod; import
  org.springframework.web.bind.annotation.RequestParam; import
  org.springframework.web.bind.annotation.RestController;

import com.cg.hms.entities.Nurse;
import com.cg.hms.entities.Patient;
import com.cg.hms.services.PatientServiceImpl;
  
  @RestController
  
  @RequestMapping(value="/api/patient") public class PatientController {
  private PatientServiceImpl service;
  
  @Autowired public void setService(PatientServiceImpl service) { this.service
  = service; }
  
  @PostMapping public ResponseEntity<String> addPatient(@RequestBody Patient
  patient){ service.addPatientReport(patient); return new
  ResponseEntity<String>("created",HttpStatus.OK); }
  
  @GetMapping public ResponseEntity<List<Patient>> getPatients(){ return new
  ResponseEntity<List<Patient>>(service.getallPatients(),HttpStatus.OK); }
  
  @GetMapping(value="/{physicianid}") public ResponseEntity<List<Patient>>
  getPatientId(@PathVariable Integer physicianid){ return new
  ResponseEntity<List<Patient>>(service.getParticularPhysicians(physicianid),
  HttpStatus.OK); }
  
  @GetMapping(value="/{physicianid}/{patientid}") public
  ResponseEntity<Patient> getPatient(@PathVariable int
  pid,@RequestParam(value="patientid") Integer id){ Patient pat =
  service.getParticularPatient(pid, id); return new
  ResponseEntity<Patient>(pat,HttpStatus.OK); }
  
  @GetMapping(value="/insurance/{patientid}") public ResponseEntity<Integer>
  getInsurance(@PathVariable Integer patientid){ Integer insid =
  service.getInsuranceOfPatient(patientid); return new
  ResponseEntity<Integer>(insid,HttpStatus.OK); }
  
  @RequestMapping(method= RequestMethod.PUT, value = "/address") public
  ResponseEntity<Patient> updateaddr(@RequestBody Patient
  pat,@RequestParam("id") Integer empid) { Patient patient =
  service.updateAddressOfPatient(empid, pat); return new
  ResponseEntity<Patient>(patient,HttpStatus.OK); }
  
  @RequestMapping(method= RequestMethod.PUT, value = "/phone") public
  ResponseEntity<Patient> updatephone(@RequestBody Patient
  pat,@RequestParam("phone") Integer phone) { Patient patient =
  service.updatePhoneOfPatient(phone, pat); return new
  ResponseEntity<Patient>(patient,HttpStatus.OK);
  
  } }
 