package com.cg.hms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;
import com.cg.hms.entities.TrainedIn;

@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);
	public List<Department> getallDepartments();
	public Department getDepartmentDetailByDeptId(Integer departmentid);
	public Physician getHeadOfDepartmentDetails(Integer head);
	public List<TrainedIn> getHeadCertificationDetailByDeptId(Integer departmentid);
	public List<Department> getDepartmentByHeadId(Integer physicianid);
	public Boolean PhysicianIsHeadOfAnyDepartmentOrNot(Integer physicianid);
	public Department updateDepartmentHeadId(Department head,Integer departmentid);
	public Department updateNameOfDepartment(Integer departmentid ,Department dep);
	
	
}
