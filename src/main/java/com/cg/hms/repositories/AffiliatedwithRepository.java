package com.cg.hms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.AffId;
import com.cg.hms.entities.Affiliatedwith;
import com.cg.hms.entities.Department;
import com.cg.hms.entities.Physician;

@Repository
public interface AffiliatedwithRepository extends JpaRepository<Affiliatedwith,AffId> {
public List<Affiliatedwith> findByDepartment(Department dep);
@Query("SELECT a FROM Affiliatedwith a WHERE a.physician.employeeId = :physicianId")
public List<Affiliatedwith> findByPhysician(int physicianId);
@Query("SELECT COUNT(a) FROM Affiliatedwith a WHERE a.department.departmentId = :depid")
public Integer countByDepartment(int depid);

@Query("SELECT a.physician from Affiliatedwith a WHERE a.department.departmentId = :depid")
public List<Physician> findByDepId(int depid);
}
