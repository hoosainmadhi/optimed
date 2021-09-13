package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.entity.Script;
import com.madhis.optimed.service.ConsultService;
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
	private ScriptService scriptService;

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
		//	scriptService.saveScript(script);
		return "dispense";
	}


	//	@RequestMapping(value="consult/{id}",method = {RequestMethod.POST})
	//	public String consultForm(Model model, @PathVariable(value="id") Long patientId){
	//		  model.addAttribute(patientService.getPatientById(patientId));
	//		  return "consult";
	//	}
}
