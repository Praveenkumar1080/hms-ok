package com.cg.hms.repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hms.entities.Appointment;
import com.cg.hms.entities.Nurse;
import com.cg.hms.entities.Patient;
import com.cg.hms.entities.Physician;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	public List<Appointment> findByStartTime(Timestamp startdate);
	@Query("SELECT a from Appointment a WHERE a.patient.ssn=?1")
	public List<Appointment> findByPatient(int patientId);
	@Query("SELECT a from Appointment a WHERE a.physician.employeeId=?1")
	public List<Appointment> findByPhysician(int physicianId);
	@Query("SELECT a from Appointment a WHERE a.nurse.employeeId=?1")
	public List<Appointment> findByNurse(int nurseId);
	@Query("SELECT a.patient from Appointment a WHERE a.patient.ssn= :patientid AND a.physician.employeeId = :physicianid")
	public Optional<Patient> findByPhysicianAndPatientId(int patientid,int physicianid);

}
