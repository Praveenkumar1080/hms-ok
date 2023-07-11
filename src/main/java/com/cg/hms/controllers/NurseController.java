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

import com.cg.hms.entities.Nurse;
import com.cg.hms.services.NurseServiceImp;

@RestController
@RequestMapping(value="/api/nurse")
public class NurseController {
private NurseServiceImp service;
@Autowired
public void setService(NurseServiceImp service) {
	this.service = service;
}
@PostMapping(value="/")
public ResponseEntity<Nurse> addNurse(@RequestBody Nurse nurse) {
Nurse savedObj = service.saveNurse(nurse);
ResponseEntity<Nurse> res = new ResponseEntity<Nurse>(savedObj,HttpStatus.CREATED);
return res;
     }
@GetMapping(value="/")
	public ResponseEntity<List<Nurse>> getListNurse() {
	    List<Nurse> list = service.getallNurses();
	    ResponseEntity<List<Nurse>> res = new ResponseEntity<>(list,HttpStatus.OK);
		return res;
	}
@GetMapping(value="/{empid}")
	public ResponseEntity<Nurse>getNurseByEmployeeId(@PathVariable Integer empid){
		Nurse nurse = service.getDetailOfNurseByemployeeId(empid);
		ResponseEntity<Nurse> res = new ResponseEntity<>(nurse,HttpStatus.OK);
		return res;
		}
	@GetMapping(value="/position/{empid}")
		public ResponseEntity<String> getPositionByEmployeeId(@PathVariable Integer empid) {
			
            String pos = service.getPositionOfNurseByemployeeId(empid);
			ResponseEntity<String> res = new ResponseEntity<>(pos,HttpStatus.OK);
			return res;
		}
	@GetMapping(value="/registered/{empid}")
			public ResponseEntity<Boolean> getRegisterNurse(@PathVariable Integer empid) {
				
                Boolean register = service.NurseIsRegisteredOrNot(empid);
				ResponseEntity<Boolean> res = new ResponseEntity<>(register,HttpStatus.OK);
				return res;
			}
	@RequestMapping(method= RequestMethod.PUT, value = "/registered")
	public ResponseEntity<Nurse> updateNurseRegister(@RequestBody Nurse
			 nur,@RequestParam("empid") Integer empid) {
					Nurse nurse = service.updateValueOfregistred(empid,nur);
		            ResponseEntity<Nurse> res = new ResponseEntity<>(nurse,HttpStatus.OK);
					return res;
				}
	@RequestMapping(method= RequestMethod.PUT, value = "/ssn")
		public ResponseEntity<Nurse> updateSsnByEmpid(@RequestBody Nurse
				 nur,@RequestParam("empid") Integer empid) {
		        Nurse nurse = service.updateValueOfSSN(empid,nur);
		        ResponseEntity<Nurse> res = new ResponseEntity<>(nurse,HttpStatus.OK);
				return res;
			}
}
