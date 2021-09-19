package com.madhis.optimed.service;

import com.madhis.optimed.entity.Patient;
import java.util.List;

public interface PatientService {
    
   //getAll,getById,insert(save),update,delete
	
    public List<Patient> fetchPatientList(String keyword);
    
    public Patient findPatientById(Long id);
    
    public List<Patient> fetchPatientByName(String name);
    
    public Patient savePatient(Patient patient);
    
    public void deletePatientById(Long patientId);
    
    public void updatePatient(Long id, Patient patient);

	void updPatient(Patient patient);
    
}
