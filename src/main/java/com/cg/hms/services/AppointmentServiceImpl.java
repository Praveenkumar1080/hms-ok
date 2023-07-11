package com.cg.hms.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entities.Appointment;
import com.cg.hms.entities.Nurse;
import com.cg.hms.entities.Patient;
import com.cg.hms.entities.Physician;
import com.cg.hms.entities.Room;
import com.cg.hms.entities.Stay;
import com.cg.hms.exceptions.DuplicateEntryException;
import com.cg.hms.exceptions.NoEntryException;
import com.cg.hms.exceptions.NoRecordsException;
import com.cg.hms.exceptions.NoSuchElementException;
import com.cg.hms.repositories.AppointmentRepository;
import com.cg.hms.repositories.NurseRepository;
import com.cg.hms.repositories.PatientRepository;
import com.cg.hms.repositories.PhysicianRepository;
import com.cg.hms.repositories.StayRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	private AppointmentRepository appointmentRepository;
	private PatientRepository patientRepository;
	private PhysicianRepository physicianRepository;
	private NurseRepository nurseRepository;
	private StayRepository stayRepository;
	@Autowired
	public void setRepo(StayRepository stayRepo) {
		this.stayRepository = stayRepo;
	}
	@Autowired
	public void setNurrepo(NurseRepository nurrepo) {
		this.nurseRepository = nurrepo;
	}
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	@Autowired
	public void setService(PatientRepository patientrepo) {
		this.patientRepository = patientrepo;
	}
	@Autowired
	public void setService(PhysicianRepository phyrepo) {
		this.physicianRepository = phyrepo;
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		if(appointmentRepository.findById(appointment.getAppointmentId()).isEmpty())
			return appointmentRepository.save(appointment);
		throw new DuplicateEntryException("");
		
	}

	@Override
	public List<Appointment> getallAppointments() {
		
		List<Appointment> list = appointmentRepository.findAll();
		if(list.isEmpty())
		 throw new NoRecordsException("");
		return list;
		
    }
	
	@Override
	public List<Appointment> getallAppointmentsByStartDate(Timestamp startdate) {
		
		
		List<Appointment> appointments = appointmentRepository.findByStartTime(startdate);
		if(appointments.isEmpty())
		 throw new NoSuchElementException("");
		return appointments;
    }
    

	@Override
	public Patient getPatientInfoByAppointmentId(Integer appointementId) {
		 return appointmentRepository.findById(appointementId).orElseThrow(()-> new NoSuchElementException("n")).getPatient();
	    }

	@Override
	public Physician getPhysicianDetailByAppointmentId(int appointmentId) {
		return appointmentRepository.findById(appointmentId).orElseThrow(()-> new NoSuchElementException("")).getPhysician();
    }
	
	@Override
	public Nurse getNurseDeatailByAppointmentId(int appointmentId) {
		 return appointmentRepository.findById(appointmentId).orElseThrow(()-> new NoSuchElementException("")).getNurse();
	    }

	@Override
	public String getExaminationRoomByAppointmentId(int appointmentId) {
		 return appointmentRepository.findById(appointmentId).orElseThrow(()-> new NoSuchElementException("")).getExaminationRoom();
	    }
	

	@Override
	public List<Physician> getPhysiciansByPatientId(int patientId) {
		return findByPatientId(patientId).stream().map(x->x.getPhysician()).collect(Collectors.toList());
	}

	@Override
	public Physician getPhysicianDetailByPatientIdAndDate(int patientId, Timestamp date) {
		return findByPatientId(patientId).stream().filter(p -> p.getStartTime().equals(date))
				.map(p -> p.getPhysician()).findFirst().orElseThrow(()-> new NoSuchElementException("")); 
    }

	@Override
	public List<Nurse> getNursesByPatientId(int patientId) {
		
		return findByPatientId(patientId).stream().map(x->x.getNurse()).collect(Collectors.toList());
    }
	

	@Override
	public Nurse getPhysicianDetailByNurseIdAndDate(int patientId, Timestamp date) {
		return findByPatientId(patientId).stream().filter(x->x.getStartTime().equals(date)).map(x->x.getNurse()).findFirst().orElseThrow(()-> new NoSuchElementException(""));
	    }
	

	@Override
	public List<Timestamp> getAppointmentDatesByPatientId(int patientId) {
        return findByPatientId(patientId).stream().map(x->x.getStartTime()).collect(Collectors.toList());
    }
		

	@Override
	public List<Patient> getPatientsCheckedByPhysician(int physicianId) {
		return findByPhysicianId(physicianId).stream().map(x->x.getPatient()).collect(Collectors.toList());
    }

	@Override
	public List<Patient> getPatientsCheckedByPhysicianOnDate(int physicianId, Timestamp date) {
		return findByPhysicianId(physicianId).stream().filter(i->i.getStartTime().equals(date)).map(x->x.getPatient()).collect(Collectors.toList());
	}
	

	@Override
	public Patient getPatientCheckedByPhysician(int patientId, Integer physicianId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow(()->new NoSuchElementException(""));
		return findByPhysicianId(physicianId).stream().filter(x->x.getPatient().equals(patient)).findFirst().orElseThrow(()->new NoSuchElementException("")).getPatient();
    }
	

	@Override
	public List<Patient> getPatientsCheckedByNurse(int nurseId) {
		return findByNurseId(nurseId).stream().map(x->x.getPatient()).collect(Collectors.toList());
    }
	@Override
	public Patient getPatientCheckedByNurse(int nurseid,int patientId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow(NoSuchElementException::new);
		return findByNurseId(nurseid).stream().filter(x->x.getPatient().equals(patient)).findFirst().orElseThrow(()-> new NoSuchElementException("")).getPatient();
		
    }
	

	@Override
	public List<Patient> getPatientsCheckedByNurseOnDate(int nurseId, Timestamp date) {
		Nurse nur = nurseRepository.findById(nurseId).get();
		List<Appointment> app = appointmentRepository.findByNurse(nurseId);
		List<Patient> patient = new ArrayList<>();
		for(Appointment i:app) {
			if(i.getStartTime().compareTo(date)==0) {
             patient.add(i.getPatient());
		}
		}
        return patient;
    }
	
	@Override
	public Room getRoomDetailsByPatientIdAndDate(int patientId, Timestamp date) {
		Patient patient = patientRepository.findById(patientId).get();
		List<Stay> stay = stayRepository.findByPatient(patient);
		return stay.stream().filter(x->x.getStartTime().compareTo(date)==0).map(x->x.getRoom()).findFirst().get();
		
    
	}

	@Override
	public List<Room> getRoomDetailsByPhysicianIdAndDate(int physicianId, Timestamp date) {
		Physician phy = physicianRepository.findById(physicianId).get();
		List<Appointment> appointments = appointmentRepository.findByPhysician(physicianId);
		Patient patient = appointments.stream().filter(x->x.getStartTime().compareTo(date)==0).map(x->x.getPatient()).findAny().get();
		List<Stay> stay = stayRepository.findByPatient(patient);
		return stay.stream().filter(x->x.getStartTime().compareTo(date)==0).map(x->x.getRoom()).collect(Collectors.toList());
    }
	

	@Override
	public List<Room> getRoomDetailsByNurseIdAndDate(int nurseId,Timestamp date) {
		Nurse nurse = nurseRepository.findById(nurseId).get(); 
		List<Appointment> appointments = appointmentRepository.findByNurse(nurseId);
		Patient patient = appointments.stream().filter(x->x.getStartTime().compareTo(date)==0).map(x->x.getPatient()).findAny().get();
		List<Stay> stay = stayRepository.findByPatient(patient);
		return stay.stream().filter(x->x.getStartTime().compareTo(date)==0).map(x->x.getRoom()).collect(Collectors.toList());
    }
	

	@Override
	public Appointment updateExaminationRoomByAppointmentId(int appointmentId, String newExaminationRoom) {
		Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()-> new NoSuchElementException(""));
		appointment.setExaminationRoom(newExaminationRoom);
		return appointmentRepository.save(appointment);
    }
	@Override
	public Patient getPatientCheckedByPhysician(Integer physicianId) {
		return findByPhysicianId(physicianId).stream().findFirst().orElseThrow(()-> new NoSuchElementException("")).getPatient();
	}
	///
	public List<Appointment> findByPhysicianId(Integer physicianId){
		List<Appointment> appointments = appointmentRepository.findByPhysician(physicianId);
		if(appointments.isEmpty())
			throw new NoEntryException("");
		return appointments;
	}
	public List<Appointment> findByPatientId(Integer patientId){
		List<Appointment> appointments = appointmentRepository.findByPatient(patientId);
		if(appointments.isEmpty())
			throw new NoEntryException("");
		return appointments;
	}
	public List<Appointment> findByNurseId(Integer nurseId){
		List<Appointment> appointments = appointmentRepository.findByNurse(nurseId);
		if(appointments.isEmpty())
			throw new NoEntryException("");
		return appointments;
	}
	
	
	
	

}
