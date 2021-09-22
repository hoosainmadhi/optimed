package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController


@RequestMapping("/api")
class PatientRestController {

	@Autowired
	private PatientService patientService;


	@RequestMapping(value = "/",method = {RequestMethod.GET}) 
	public String index(){
		return "welcome - Rest Controller Managing all Rest calls";
	}


	@RequestMapping(value = "/patients",method = {RequestMethod.GET})
	public List<Patient> fetchPatientList(@Param("keyword") String keyword){
		return patientService.fetchPatientList(keyword);
	}

	//@RequestMapping(value = "/rest_get_patient/{id}", method = {RequestMethod.GET})
	@GetMapping(value = "/patient/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Patient getPatientById(@PathVariable(value="id") Long patientId){
		return patientService.findPatientById(patientId);	
	} 	

//	@RequestMapping(value= "/patient", method = {RequestMethod.POST})
	@PostMapping("/patient")
	public Patient savePatient(@RequestBody Patient patient){
		
		return patientService.savePatient(patient);
	}


	@RequestMapping(value= "/patient/{id}", method = {RequestMethod.DELETE})
	public void deletePatientById(@PathVariable(value="id") Long patientId){
		patientService.deletePatientById(patientId);
	}


	//@RequestMapping(value="/rest_update_patient/{id}", method = {RequestMethod.PUT})
	@PutMapping({"/patient/{id}"})
	public void updatePatient(@RequestBody Patient patient, @PathVariable(value="id") Long patientId){
		patientService.updatePatient(patientId, patient);
	}

	@PutMapping("/rest_upd_patient")
	public Patient updPatient(@RequestBody Patient patient){
		return  patientService.savePatient(patient);
	}


}
