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
	
	public List<Patient> getPatients(){
		return patientDao.getPatients();
	}

	public boolean addPatient(Patient patient) {
		
		return patientDao.addPatient(patient);
		
	}

	public boolean deletePatient(int id) {
		return patientDao.deletePatient(id);
	}

	public boolean updatePatient(Patient patient) {
		return patientDao.updatePatient(patient);
	}

	public Patient getPatientById(int id) {
		// TODO Auto-generated method stub
		return patientDao.getPatientById(id);
	}
	
	public List<State> getRooms(){
		return patientDao.getRooms();
	}
	
}
