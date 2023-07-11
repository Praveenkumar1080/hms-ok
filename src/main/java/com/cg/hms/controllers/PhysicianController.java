package com.cg.hms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hms.entities.Physician;
import com.cg.hms.services.PhysicianServiceImpl;

@RestController
@RequestMapping(value="/api/physician")
public class PhysicianController {
public PhysicianServiceImpl service;
@Autowired
public void setService(PhysicianServiceImpl service) {
	this.service = service;
}
String str = null;
@PostMapping
public ResponseEntity<String> savePhysician(@RequestBody Physician physician){
	if(service.savePhysician(physician)!=null) {
		str = "Record Created Successfully";
	}
	else {
		str = "validation failed";
	}
	return new ResponseEntity<String>(str,HttpStatus.OK);
}
@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<Physician> getPhysicianByName(@RequestParam("name") String name){
	Physician obj = service.getPhysicianDetailsByName(name);
	return new ResponseEntity<Physician>(obj,HttpStatus.OK);
}


  @GetMapping(value="/")
  public ResponseEntity<List<Physician>> getPhysicianByPos(@RequestParam("pos") String pos){
  List<Physician> obj = service.getallPhysiciansByPositions(pos);
  return new ResponseEntity<List<Physician>>(obj,HttpStatus.OK); }
 
@GetMapping(value ="/{empid}")
public ResponseEntity<Physician> getPhysicianByEmpid(@PathVariable Integer empid){
	Physician obj = service.getPhysicianByEmpid(empid);
	return new ResponseEntity<Physician>(obj,HttpStatus.OK);
}

 @RequestMapping(method= RequestMethod.PUT, value = "/update/position") public
 ResponseEntity<Physician> updatePhysicianPosition(@RequestBody Physician
 physician,@RequestParam("empid") Integer empid){
 Physician obj = service.updatePositionOfPhysician(empid, physician);
 return new ResponseEntity<Physician>(obj,HttpStatus.OK); 
 }
 @RequestMapping(method= RequestMethod.PUT, value = "/update/name") public
 ResponseEntity<Physician> updatePhysicianName(@RequestBody Physician
 physician,@RequestParam("empid") Integer empid){ 
 Physician obj = service.updateNameOfPhysician(empid, physician);
 return new ResponseEntity<Physician>(obj,HttpStatus.OK); 
 }
 @RequestMapping(method= RequestMethod.PUT, value = "/update/ssn") 
 public ResponseEntity<Physician> updatePhysicianSsn(@RequestBody Physician
 physician,@RequestParam("empid") Integer empid){
 Physician obj = service.updateSSNOfPhysician(empid, physician);
 return new ResponseEntity<Physician>(obj,HttpStatus.OK); 
 }
 
 




}