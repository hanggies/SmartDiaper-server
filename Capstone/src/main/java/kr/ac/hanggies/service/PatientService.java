package kr.ac.hanggies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hanggies.dao.PatientDao;
import kr.ac.hanggies.model.Patient;
import kr.ac.hanggies.model.State;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;
	
	public List<Patient> getAllPatients(){
		return patientDao.getAllPatients();
	}
	
	public List<Patient> getRoomPatients(String room){
		return patientDao.getRoomPatients(room);
	}

	public boolean addPatient(Patient patient) {
		return patientDao.addPatient(patient);
		
	}

	public boolean deletePatient(String sid) {
		return patientDao.deletePatient(sid);
	}

	public boolean updatePatient(Patient patient) {
		return patientDao.updatePatient(patient);
	}

	public Patient getPatientById(String sid) {
		return patientDao.getPatientById(sid);
	}
	
	public List<State> getRooms(){
		return patientDao.getRooms();
	}
	
}
