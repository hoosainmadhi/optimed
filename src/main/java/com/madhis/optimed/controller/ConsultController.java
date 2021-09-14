package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.entity.Script;
import com.madhis.optimed.service.ConsultService;
import com.madhis.optimed.service.DispenseService;
import com.madhis.optimed.service.PatientService;
import com.madhis.optimed.service.ScriptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsultController {

	@Autowired
	private ConsultService consultService;

	@Autowired
	private PatientService patientService;	
	
	@Autowired
	private PatientController patientController;

	@RequestMapping(value="/consult/{id}/dispense",method = {RequestMethod.POST})
	public String consultForm(Model model, 
			@ModelAttribute("consult") Consult consult, 
			@ModelAttribute("script") Script script, 
			@PathVariable(value="id") Long patientId){ 
		Dispense dispense = new Dispense();
		model.addAttribute(dispense);
		Patient patient = patientService.findPatientById(patientId);
		model.addAttribute(patient);

		System.out.println("script = " + consult.getScript());
		patient.getConsults().add(consult);
		consult.setScript(consult.getScript());
		System.out.println("consult = " + consult);
		consultService.addConsult(consult);
		return "dispense";
	}

	@RequestMapping(value = "/delete/patient/{pid}/consult/{cid}")
	public String deleteDispenseById(Model model,
									@PathVariable(value = "pid") Long patientId,
									@PathVariable(value = "cid") Long consultId) {
		consultService.deleteConsultById(consultId);
//		model.addAttribute(patientId);
		
		Consult consult = new Consult();
		model.addAttribute(consult);
		return patientController.showConsultForm(model, patientId);

	}

}
