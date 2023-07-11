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

import com.cg.hms.entities.Affiliatedwith;
import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;
import com.cg.hms.services.AffiliatedServiceImpl;

 


@RestController
@RequestMapping(value="/api/affiliated_with")
public class AffiliatedwithController{
 private AffiliatedServiceImpl service;
 @Autowired
 public void setService(AffiliatedServiceImpl service) {
	 this.service = service;
 }
@PostMapping(value="/post")
    public ResponseEntity<String> saveAffiliatedwith(@RequestParam("id") int id) {
	  service.saveAffiliatedwith(id);
      return new ResponseEntity<String>("Successfully Created",HttpStatus.CREATED);
}
@GetMapping(value="/physicians/{depid}")
     public ResponseEntity <List<Physician>> getPhysiciansByDepartment(@PathVariable int depid) {
	 List<Physician> physicians = service.getPhysiciansByDepartment(depid);
     return new ResponseEntity<List<Physician>>(physicians,HttpStatus.OK);
}
@GetMapping(value="/department/{physicianid}")
    public ResponseEntity<List<Department>> getDepartmentsByPhysician(@PathVariable int physicianid) {
	  List<Department> departments = service.getDepartmentsByPhysician(physicianid);
      return new ResponseEntity<>(departments,HttpStatus.OK);
}
@GetMapping(value="/countphysician/{depid}")
    public ResponseEntity<Integer> countPhysiciansByDepartment(@PathVariable int depid) {
      Integer count = service.countPhysiciansByDepartment(depid);
      return new ResponseEntity<Integer>(count,HttpStatus.OK);
}
@GetMapping(value="/{physicianid}")
    public ResponseEntity<Boolean> getPrimaryAffiliation(@PathVariable int physicianid) {
    Boolean affiliation = service.getPrimaryAffiliation(physicianid); 
	return new ResponseEntity<>(affiliation,HttpStatus.OK);
}
@RequestMapping(method = RequestMethod.PUT,value="/primary")
    public ResponseEntity <Boolean> updatePrimaryAffiliation(@RequestBody Affiliatedwith aff,@RequestParam("physicianid")int physicianid) {
    Boolean pAffiliation = service.updatePrimaryAffiliation(physicianid, aff);
	return new ResponseEntity<>(pAffiliation,HttpStatus.OK);
  }
}