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

import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;
import com.cg.hms.entities.TrainedIn;
import com.cg.hms.services.DepartmentServiceImpl;

@RestController
@RequestMapping(value="/api/department")
public class DepartmentController {
private DepartmentServiceImpl service;
@Autowired
public void setService(DepartmentServiceImpl service) {
	this.service = service;
}
@PostMapping
public ResponseEntity<String> addDepart(@RequestBody Department dep) {
	service.saveDepartment(dep);
    ResponseEntity<String> res = new ResponseEntity<String>("success",HttpStatus.CREATED);
    return res;
}
@GetMapping(value="/")
	public ResponseEntity<List<Department>> getListDepart() {
	    List<Department> list = service.getallDepartments();
		ResponseEntity<List<Department>> res = new ResponseEntity<>(list,HttpStatus.OK);
		return res;
	}
@GetMapping(value="/{deptid}")
	public ResponseEntity<Department> searchDepartById(@RequestParam(value="deptid") Integer deptid) {
	Department dep = service.getDepartmentDetailByDeptId(deptid);	
	ResponseEntity<Department> res = new ResponseEntity<>(dep,HttpStatus.OK);
	return res;
}
@GetMapping(value="/head/{deptid}")
	public ResponseEntity<Physician> searchHeadDepart(@PathVariable int deptid) {
	
        Physician phy = service.getHeadOfDepartmentDetails(deptid);
		ResponseEntity<Physician> res = new ResponseEntity<>(phy,HttpStatus.OK);
		return res;
}
@GetMapping(value="/headcertification/{deptid}")
	public ResponseEntity<List<TrainedIn>> searchCertificationByDepartId(@PathVariable Integer deptid) {
		List<TrainedIn> list = service.getHeadCertificationDetailByDeptId(deptid);
	    ResponseEntity<List<TrainedIn>> res = new ResponseEntity<>(list,HttpStatus.OK);
		return res;
}
@RequestMapping(value="/jk", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> searchListDepartByHeadId(@RequestParam(value="head") int head) {
		List<Department> list = service.getDepartmentByHeadId(head);
		ResponseEntity<List<Department>> res = new ResponseEntity<>(list,HttpStatus.OK);
		return res;
}
@GetMapping(value="/check/{physicianid}")
	public ResponseEntity<Boolean> searchDepart(@PathVariable Integer physicianid ) {
		Boolean ishead = service.PhysicianIsHeadOfAnyDepartmentOrNot(physicianid);
		ResponseEntity<Boolean> res = new ResponseEntity<>(ishead,HttpStatus.OK);
		return res;
}
@RequestMapping(method = RequestMethod.PUT,value="/update/headid")
public ResponseEntity<Department> updateDepart(@RequestBody Department dep,@RequestParam("deptid") Integer deptid) {
    Department dept = service.updateDepartmentHeadId(dep,deptid);
	ResponseEntity<Department> res = new ResponseEntity<>(dept,HttpStatus.OK);
return res;
}
@RequestMapping(method = RequestMethod.PUT ,value="/update/deptname")
public ResponseEntity<Department> updateDepartname(@RequestBody Department dep,@RequestParam("deptid") Integer deptid) {
    Department dept = service.updateNameOfDepartment(deptid,dep);
	ResponseEntity<Department> res = new ResponseEntity<>(dept,HttpStatus.OK);
return res;
}
}
