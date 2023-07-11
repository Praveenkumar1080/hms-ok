
  package com.cg.hms.controllers;
  
  
  
  import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import
  org.springframework.web.bind.annotation.RequestParam; import
  org.springframework.web.bind.annotation.RestController;

import com.cg.hms.entities.Appointment;
import com.cg.hms.entities.Nurse;
import com.cg.hms.entities.Patient;
import com.cg.hms.entities.Physician;
import com.cg.hms.entities.Room;
import com.cg.hms.services.AppointmentServiceImpl;
  
  
  
  
  @RestController
  @RequestMapping(value="/api/appointment")
  public class AppointmentController{
  private AppointmentServiceImpl service;
  
  @Autowired public void setService(AppointmentServiceImpl service) {
  this.service = service;
  } //1
  
  @PostMapping(value="/")
  public ResponseEntity <String> saveAppointment(@RequestBody Appointment app) {
  service.saveAppointment(app);
  return new ResponseEntity<String>("Successfully Created",HttpStatus.OK);
  } //2
  
  @GetMapping public ResponseEntity <List<Appointment>> getallAppointments() {
  List<Appointment> appointments = service.getallAppointments();
  return new ResponseEntity<List<Appointment>>(appointments,HttpStatus.OK);
  } //3
  
  @GetMapping(value="/{startdate}")
  public ResponseEntity <List<Appointment>> getallAppointmentsByStartDate(@PathVariable Timestamp startdate) {
  List<Appointment> appointments = service.getallAppointmentsByStartDate(startdate);
  return new ResponseEntity<List<Appointment>>(appointments,HttpStatus.OK);
  } //4
  @GetMapping(value="/physician/{appointmentid}") public
  ResponseEntity<Physician> getPhysicianDetailByAppointmentId(@PathVariable int appointmentid) {
  Physician physician = service.getPhysicianDetailByAppointmentId(appointmentid);
  return new ResponseEntity<Physician>(physician,HttpStatus.OK);
  } //6
  
  @GetMapping(value="/nurse/{appointmentid}")
  public ResponseEntity<Nurse> getNurseDeatailByAppointmentId(@PathVariable int appointmentid) {
  Nurse nurse = service.getNurseDeatailByAppointmentId(appointmentid);
  return new ResponseEntity<>(nurse,HttpStatus.OK);
  } //7
  
  @GetMapping(value="/examinationroom/{appointmentid}")
  public ResponseEntity <String> getExaminationRoomByAppointmentId(@PathVariable int appointmentid) {
  String room = service.getExaminationRoomByAppointmentId(appointmentid);
  return new ResponseEntity<String>(room,HttpStatus.OK);
  } //8
  
  @RequestMapping(value="/physicians", method = RequestMethod.GET) 
  public ResponseEntity<List<Physician>> getPhysiciansByPatientId(@RequestParam("patientid") int patientid) {
  List<Physician> appointments = service.getPhysiciansByPatientId(patientid);
  return new ResponseEntity<>(appointments,HttpStatus.OK); 
  }
@GetMapping("/patient")
  public ResponseEntity<List<Patient>> patientController(@RequestParam(required = false) Integer physicianId, 
	        @RequestParam(required = false) Integer nurseid,
	        @RequestParam(required = false) Integer patientid,
	        @RequestParam(required = false) Integer appointmentid,
	        @RequestParam(required = false) Timestamp date) {
	  if(appointmentid != null ) {
		  Patient patients = service.getPatientInfoByAppointmentId(appointmentid);
		  return new ResponseEntity<>(Arrays.asList(patients),HttpStatus.OK);
	  }
	  else if(patientid != null && physicianId != null) {
    	  Patient patients = service.getPatientCheckedByPhysician(patientid,physicianId);
    	  return new ResponseEntity<>(Arrays.asList(patients),HttpStatus.OK); 
 
	  }
	  else if(physicianId != null && date != null) {
		  List<Patient> patients = service.getPatientsCheckedByPhysicianOnDate(physicianId, date);
		  return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);  
	  }
	  else if(physicianId != null) {
		  List<Patient> list = service.getPatientsCheckedByPhysician(physicianId);
		  return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	  }
      
      else if(nurseid != null && patientid != null) {
    	  Patient patient = service.getPatientCheckedByNurse(nurseid,patientid);
    	  return new ResponseEntity<List<Patient>>(Arrays.asList(patient),HttpStatus.OK);
	  }
      else if(nurseid != null && date != null) {
    	  
    	  List<Patient> patients = service.getPatientsCheckedByNurseOnDate(nurseid, date);
    	  return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
	  }
      else if(nurseid != null) {
    	  List<Patient> list = service.getPatientsCheckedByNurse(nurseid);
    	  return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	  }
	  return null;
  }
  //9

  @RequestMapping(value = "/physician", method=RequestMethod.GET)
  public ResponseEntity<Physician> getPhysicianDetailByPatientIdAndDate(@RequestParam("pid") int pid,@RequestParam("date")Timestamp date) { 
  Physician phy = service.getPhysicianDetailByPatientIdAndDate(pid,date);
  return new ResponseEntity<Physician>(phy,HttpStatus.OK);
  } //10
  
  @RequestMapping(value="/nurses",method = RequestMethod.GET)
  public ResponseEntity<List<Nurse>> getNursesByPatientId(@RequestParam("patientid") int patientid) {
  List<Nurse> nurses = service.getNursesByPatientId(patientid);
  return new ResponseEntity<List<Nurse>>(nurses,HttpStatus.OK);
  } //11
  
  @RequestMapping(value = "/nurse", method=RequestMethod.GET)
  public ResponseEntity<Nurse> getPhysicianDetailByNurseIdAndDate(@RequestParam("physicianid") int physicianid,@RequestParam("date") Timestamp date) {
  Nurse nurse = service.getPhysicianDetailByNurseIdAndDate(physicianid,date); 
  return new ResponseEntity<Nurse>(nurse,HttpStatus.OK);
  } //12
  
  @GetMapping(value="/date/{patientid}")
  public ResponseEntity<List<Timestamp>> getAppointmentDatesByPatientId(@PathVariable int patientid) {
  List<Timestamp> dates = service.getAppointmentDatesByPatientId(patientid);
  return new ResponseEntity<List<Timestamp>>(dates,HttpStatus.OK);
  } //13
  }
 