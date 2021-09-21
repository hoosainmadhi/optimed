package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.service.PatientService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/patients", method = { RequestMethod.GET })
	public String viewAllPatients(Model model, @Param("keyword") String keyword) {
		List<Patient> listPatients = patientService.fetchPatientList(keyword);
		model.addAttribute("listPatients", listPatients);
		return "patients";
	}

	@RequestMapping(value = "/new_patient", method = { RequestMethod.GET })
	public String newPatientForm(Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "new_patient";
		
	}

	@RequestMapping(value = "/patient/{id}/consult", method = { RequestMethod.GET })
	public String showConsultForm(Model model, @PathVariable(value = "id") Long patientId) {
		Consult consult = new Consult();
		model.addAttribute(consult); // new consults for form
		Patient patient = patientService.findPatientById(patientId); // patient object for patient details
		model.addAttribute(patient);
		model.addAttribute(patient.getConsults()); // previous consults
		return "consult";
	}
	
	

	@RequestMapping(value = "/delete/{id}")
	public String deletePatientId(@PathVariable(value = "id") Long patientId) {
		patientService.deletePatientById(patientId);
		return "redirect:/patients";

	}

	@PostMapping("/savepatients")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	// CAN DELETE  save patient form and redirect to consults page
	@RequestMapping(value = "/save_patient_", method = { RequestMethod.POST })
	public String submitForm(Model model, @ModelAttribute("patient") Patient patient) {
		Consult consult = new Consult();
		model.addAttribute("consult", consult);
		patientService.savePatient(patient);
		return "consult";
	}

	// save patient form and redirect to consults page
	@RequestMapping(value = "/save_patient", method = { RequestMethod.POST })
	public String submitPatientForm(@Valid Patient patient ,BindingResult result , Model model) {
		
		
		if (result.hasErrors()) {
			return "new_patient";
		}
		
		Consult consult = new Consult();
		model.addAttribute("consult", consult);
		patientService.savePatient(patient);
		return "consult";
	}
	
	

	@GetMapping(path = "edit_patient/{id}")
	public String editForm(Model model, @PathVariable(value = "id") Long patientId) {
		model.addAttribute("patient", patientService.findPatientById(patientId));
		return "edit_patient";
	}


	@PostMapping(value = "update_patient")
	public String updatePatient(@ModelAttribute("patient") Patient patient) {
		Long patientId = patient.getPatientId();
		System.out.println("patientId = " + patientId);
		patientService.updatePatient(patientId, patient);
		return "redirect:/patients";
	}

}
