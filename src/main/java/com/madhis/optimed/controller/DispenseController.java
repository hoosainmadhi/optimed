package com.madhis.optimed.controller;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.service.ConsultService;
import com.madhis.optimed.service.DispenseService;
import com.madhis.optimed.service.PatientService;
import javax.security.auth.message.callback.PrivateKeyCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DispenseController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DispenseService dispenseService;
	
	@Autowired
	private ConsultService consultService;
	
	
//	@RequestMapping(value="/patient/{pid}/consult/{cid}",method = {RequestMethod.POST})
	@RequestMapping(value="/patient/{pid}/consult/{cid}")
        public String dispenseForm(Model model, @ModelAttribute("dispense") Dispense dispense,@PathVariable(value="pid") Long patientId, @PathVariable(value="cid") Long consultId){
		Patient patient = patientService.findPatientById(patientId);
		Consult consult = consultService.findByConsultId(consultId);
		
		model.addAttribute("consult",consult);
		model.addAttribute("patient",patient);
		if(dispense.getDispenseItem() != null){
		    consult.getDispenses().add(dispense);
		    dispenseService.addDispense(dispense);
		}
		return "dispense";
	} 
}
