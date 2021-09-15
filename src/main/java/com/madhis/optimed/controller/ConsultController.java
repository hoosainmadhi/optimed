package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.entity.Script;
import com.madhis.optimed.service.ConsultService;
import com.madhis.optimed.service.DispenseService;
import com.madhis.optimed.service.PatientService;
import com.madhis.optimed.service.ScriptService;

import java.util.List;

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
	
	@Autowired
	private DispenseController dispenseController;
	
	@Autowired
	private DispenseService dispenseService;

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

	@RequestMapping(value = "/edit/patient/{pid}/consult/{cid}", method = { RequestMethod.GET })
	public String editConsultForm(Model model,
			@PathVariable(value = "pid") Long patientId, 
			@PathVariable(value = "cid") Long consultId){
		
		model.addAttribute("patient", patientService.findPatientById(patientId));
		model.addAttribute("consult", consultService.findByConsultId(consultId));
		System.out.println("consult = " + consultService.findByConsultId(consultId));
		//		consultService.updateConsult(consultId, consult);
		return "edit_consult";
	}
	
	@RequestMapping(value="update/patient/{pid}/consult/{cid}",method = {RequestMethod.POST})
	public String updateConsult(Model model,
								@ModelAttribute("consult") Consult consult,
								@ModelAttribute("patient") Patient patient,
								@PathVariable(value = "pid") Long patientId,
								@PathVariable (value = "cid") Long consultId) {
		
		System.out.println("consultId = " + consultId);
		System.out.println("patientId = " + patientId);
		List<Dispense> dispenses = dispenseService.findDispensesByConsultId(consultId);
		model.addAttribute(dispenses);
		Dispense dispense = new Dispense();
		System.out.println("dispenses = " + dispenses);
		consultService.updateConsult(consultId, consult);
		System.out.println("consult = " + consult);
		return dispenseController.dispenseForm(model, dispense, patientId, consultId);
	}

	@RequestMapping(value = "/delete/patient/{pid}/consult/{cid}")
	public String deleteDispenseById(Model model,
									@PathVariable(value = "pid") Long patientId,
									@PathVariable(value = "cid") Long consultId) {
		consultService.deleteConsultById(consultId);
		
		Consult consult = new Consult();
		model.addAttribute(consult);
		return patientController.showConsultForm(model, patientId);
	}
	

}
