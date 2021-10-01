package com.madhis.optimed.service;

import com.madhis.optimed.dto.ReportDTO;
import com.madhis.optimed.entity.Consult;
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
		patientFromDb.setDob(patient.getDob());
		patientFromDb.setPostalAddress(patient.getPostalAddress());
		patientFromDb.setEmail(patient.getEmail());
		patientFromDb.setTelNo(patient.getTelNo());
		patientFromDb.setPrincipalMember(patient.getPrincipalMember());
		patientRepository.save(patientFromDb);
	}

	
	// does not work so nicely - with orphanRemoval = true - need to research
	@Override 
	public void updPatient(Patient patient){
		patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Long patientId){
		patientRepository.deleteById(patientId);
	}
	
	@Override
	
	public Patient findByPatientNumber(String patientNumber) {
		return patientRepository.findByPatientNumber(patientNumber);
	}
	
//	public  List<ReportDTO> getAllReportDTO(){
//		return null;
//	}

	
//	private ReportDTO convertEntityToDto(Patient patient) {
//		ReportDTO reportDTO = new ReportDTO();
//		reportDTO.setPatientName(patient.getPatientName());
//		return reportDTO;
		
		
//	}
		
	
}
