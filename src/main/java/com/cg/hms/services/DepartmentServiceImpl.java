package com.cg.hms.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;
import com.cg.hms.entities.TrainedIn;
import com.cg.hms.exceptions.DuplicateEntryException;
import com.cg.hms.exceptions.NoEntryException;
import com.cg.hms.exceptions.NoRecordsException;
import com.cg.hms.exceptions.NoSuchElementException;
import com.cg.hms.repositories.DepartmentRepository;
import com.cg.hms.repositories.TrainedInRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository ;
	private TrainedInRepository trainedinRepository ;
	
	
   @Autowired
	public void setServices(DepartmentRepository departmentRepository,TrainedInRepository trainedinRepository) {
		this.departmentRepository = departmentRepository;
		this.trainedinRepository = trainedinRepository;
	
	}

	@Override
	//1
	public Department saveDepartment(Department department) {
		if(departmentRepository.findById(department.getDepartmentId()).isEmpty())
			return departmentRepository.save(department);
		throw new DuplicateEntryException("");
		
	}

	@Override
	//2
	public List<Department> getallDepartments() {
		
		List<Department> departments = departmentRepository.findAll();
		if(departments.isEmpty())
		  throw new NoRecordsException("");
		return departments;
	}

	@Override
	//3
	public Department getDepartmentDetailByDeptId(Integer departmentid) {
		
		return departmentRepository.findById(departmentid).orElseThrow(()-> new NoSuchElementException("department not found"+departmentid));
	}

	@Override
	//4
	public Physician getHeadOfDepartmentDetails(Integer depid) {
		return departmentRepository.findbyhe(depid).orElseThrow(()-> new NoSuchElementException(""));
	}

	@Override
	  public List<TrainedIn> getHeadCertificationDetailByDeptId(Integer departmentid)
	  { 
	  Physician physician = departmentRepository.findbyhe(departmentid).orElseThrow(()-> new NoSuchElementException(""));
	  List<TrainedIn> certifications=trainedinRepository.findByPhysician(physician);
	  if(certifications.isEmpty())
		  throw new NoEntryException("");
	  return certifications; 
	  }
	@Override
	//6
	public List<Department> getDepartmentByHeadId(Integer head) {

		List<Department> departments =  departmentRepository.findByHead(head);
		if(departments.isEmpty())
			throw new NoRecordsException();
		return departments;
	}

	@Override
	//7
	public Boolean PhysicianIsHeadOfAnyDepartmentOrNot(Integer physicianid) {
		List<Department> list = getDepartmentByHeadId(physicianid);
		if(list.isEmpty())
		  throw new NoEntryException("");
		return true;
	}

	@Override
	//8
	public Department updateDepartmentHeadId(Department dep, Integer departmentid) {
		Department department=departmentRepository.findById(departmentid).orElseThrow(()->new NoSuchElementException("department not found"));
		department.setHead(dep.getHead());
		return departmentRepository.save(department);
		
	}

	@Override
	//9
	public Department updateNameOfDepartment(Integer departmentid,Department dep) {
		Department department=departmentRepository.findById(departmentid).orElseThrow(()->new NoSuchElementException("department not found"));
		department.setName(dep.getName());
		return departmentRepository.save(department);
		
		
	}

	

}
