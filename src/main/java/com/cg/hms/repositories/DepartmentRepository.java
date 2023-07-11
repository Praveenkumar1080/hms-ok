package com.cg.hms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query("SELECT d FROM Department d WHERE d.head.employeeId=?1")
	public List<Department> findByHead(int physicianid);
	@Query("SELECT d.head FROM Department d WHERE d.head.employeeId=?1")
	public Optional<Physician> findbyhe(int id);
	
}
