package com.madhis.optimed.service;

import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.repository.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//getAll,getById,insert(save),update,delete
@Service
public class PatientServiceImpl implements PatientService {   

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> fetchPatientList(String keyword){
		if (keyword != null){
			return patientRepository.search(keyword);
		}
		return patientRepository.findAll();
	}

	@Override
	public Patient findPatientById(Long patientId){
		return patientRepository.findByPatientId(patientId);
		//return patientRepository.findById(patientId).get();
	}

	@Override
	public List<Patient> fetchPatientByName(String  patientName){
		return patientRepository.findByPatientName(patientName);
	}

	@Override
	public Patient savePatient(Patient patient){
		return patientRepository.save(patient);
	}

	@Override
	public void updatePatient(Long id, Patient patient){
		Patient patientFromDb = patientRepository.findByPatientId(id);
		patientFromDb.setPatientName(patient.getPatientName());
		patientFromDb.setPatientNumber(patient.getPatientNumber());
		patientFromDb.setMedicalAid(patient.getMedicalAid());
		patientFromDb.setMedicalAidNumber(patient.getMedicalAidNumber());
		patientRepository.save(patientFromDb);
	}

	@Override
	public void deletePatientById(Long patientId){
		patientRepository.deleteById(patientId);
	}
}
