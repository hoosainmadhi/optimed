package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Dispense;
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

@Controller
public class DispenseController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DispenseService dispenseService;
	
	@Autowired
	private ConsultService consultService;
	
	@Autowired
	private ScriptService scriptService;
	
	
//	@RequestMapping(value="/patient/{pid}/consult/{cid}",method = {RequestMethod.POST})
	@RequestMapping(value="/patient/{pid}/consult/{cid}")
        public String dispenseForm(Model model, @ModelAttribute("dispense") Dispense dispense,@ModelAttribute("script") Script script, @PathVariable(value="pid") Long patientId, @PathVariable(value="cid") Long consultId){
		
		Patient patient = patientService.findPatientById(patientId);
		Consult consult = consultService.findByConsultId(consultId);
		
		model.addAttribute("consult",consult);
		model.addAttribute("patient",patient);
		model.addAttribute("dispense",new Dispense());
		model.addAttribute("script", new Script());
		if(dispense.getDispenseItem() != null){
		    consult.getDispenses().add(dispense);
		    dispenseService.addDispense(dispense);
		}
			
			script.setConsult(consult);
			System.out.println("script = " + script);
		    scriptService.addScript(script);
		return "dispense";
	} 
}
