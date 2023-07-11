package com.cg.hms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hms.entities.Physician;
import com.cg.hms.entities.Procedures;
import com.cg.hms.entities.TrainedIn;
import com.cg.hms.services.TrainedInServiceImpl;

@RestController
@RequestMapping(value="/api/trained_in")
public class TrainedInController {
private TrainedInServiceImpl service;
@Autowired
public void setService(TrainedInServiceImpl service) {
	this.service = service;
}
@PostMapping
public ResponseEntity<String> save(@RequestBody TrainedIn obj){
	service.saveCertification(obj);
	return new ResponseEntity<>("success",HttpStatus.OK);
}
@GetMapping(value="/treatment/{physicianid}")
public ResponseEntity<List<Procedures>> getListprocedures(@PathVariable int physicianid){
	List<Procedures> list = service.getTreatmentsByPhysicianId(physicianid);
	return new ResponseEntity<List<Procedures>>(list,HttpStatus.OK);
}
@GetMapping(value ="/physician/{proid}")
public ResponseEntity<List<Physician>> getListPhysician(@PathVariable int proid){
	List<Physician> list = service.getPhysiciansByTreatmentId(proid);
	return new ResponseEntity<List<Physician>>(list,HttpStatus.OK);
}
@PutMapping(value="/certificationexpiry")
public ResponseEntity<Boolean> updateExpiry(@RequestBody TrainedIn obj,@RequestParam("pid") int pid,@RequestParam("proid") int proid){
	Boolean b = service.updateCertificationExpiryDate(pid, proid, obj);
	return new ResponseEntity<Boolean>(b,HttpStatus.OK);
}
}

