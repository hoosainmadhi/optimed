
package com.madhis.optimed.controller;

import com.madhis.optimed.dto.ReportDTO;
import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.repository.ConsultRepository;
import com.madhis.optimed.repository.DispenseRepository;
import com.madhis.optimed.repository.PatientRepository;
import com.madhis.optimed.service.ConsultService;
import com.madhis.optimed.service.PatientService;
import com.madhis.optimed.service.ReportService;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RestController for Postman

class ConsultRestController {
    
    @Autowired
    private ConsultService consultService;
   
    @Autowired
    private PatientService patientService;
  
    @Autowired
    private DispenseRepository dispenseRepository;
   
    @Autowired
    private ReportService  reportService;

       @RequestMapping(value = "/api/consults",method = {RequestMethod.GET}) 
        public String index(){
            return "welcome - Consults Rest Controller";
        }
       
       
       @RequestMapping(value = "/api/invoice/{consultId}",method = {RequestMethod.GET}) 
        public List<ReportDTO> invoice(@PathVariable(value="consultId")Long consultId){
//    	  System.out.println("invoice = " + dispenseRepository.findInvoiceByConsultId(consultId)); 
    	   return dispenseRepository.findInvoiceByConsultId(consultId);
        }

       @RequestMapping(value = "/api/printInvoice/{consultId}",method = {RequestMethod.GET}) 
        public String printInvoice(@PathVariable(value="consultId")Long consultId) throws FileNotFoundException, JRException{
    	   reportService.exportReport(consultId);
    	   return "pdf";
        }
    
       @RequestMapping(value= "/patient/{patientId}/consult", method = {RequestMethod.POST})
	public void newConsult(@PathVariable(value="patientId") Long patientId, @RequestBody Consult consult){
		
		Patient patient = patientService.findPatientById(patientId);
		patient.getConsults().add(consult);
		consultService.addConsult(consult);
		System.out.println("consult = " + consult);
		System.out.println("patientId = " + patientId);
		System.out.println("patient.getConsults = " + patient.getConsults());
	
	}	
     
       @RequestMapping(value= "/consult/{patientId}", method = {RequestMethod.POST})
	public void addConsult(@PathVariable(value="patientId") Long patientId, @RequestBody Consult consult){
		Patient patient = patientService.findPatientById(patientId);
		System.out.println("consult = " + consult);
		System.out.println("patientId = " + patientId);
		System.out.println("getConsult =" + patient.getConsults());
		patient.getConsults().add(consult);
		//return patientService.savePatient(patient);
		//return consultService.addConsult(consult);
		//return consult;
	
	}	
//        @RequestMapping(value = "/rest_patients",method = {RequestMethod.GET}) 
//        public List<Patient> fetchPatientList(){
//            return patientService.fetchPatientList();
//        }
	

//	@RequestMapping(value= "/rest_delete_patient/{id}", method = {RequestMethod.DELETE})
//	public void deletePatientById(@PathVariable(value="id") Long patientId){
//               patientService.deletePatientById(patientId);
//        }
//        
    
//        @RequestMapping(value="/patient_form",method = {RequestMethod.GET})
//        public String newPatientForm(Model model){
//            Patient patient = new Patient();
//            model.addAttribute("patient", patient);
//            return "patient_form";
//        }
// 
//        @RequestMapping(value="/patient_form",method = {RequestMethod.POST})
//        public String submitForm(@ModelAttribute("patient") Patient patient) {
//            patientService.savePatient(patient);
//    	    return "patientadded";
//}
//        
//
//	@RequestMapping(value="/patient_delete/{id}", method = {RequestMethod.GET,RequestMethod.POST})
//        public String deletePatientId(Model model , @PathVariable(value="id") Long patientId){
//            patientService.deletePatientById(patientId);
//            List<Patient> listPatients = patientService.fetchPatientList();
//            model.addAttribute("listPatients",listPatients);
//            return "patients";  
//	}       
//	
//        @PostMapping("/savepatients")
//        public Patient savePatient(@RequestBody Patient patient){
//            return patientService.savePatient(patient);
//}


//	@DeleteMapping("/patient_delete/{id}")
//	    public String deletePatient(@PathVariable(name = "id") int id ) {
//		patientService.deletePatientById();
//		return "redirect:/";       
//}

//        @GetMapping("/patients")
//        public List<Patient> fetchPatientList(){
//            return patientService.fetchPatientList();
//        }

             
//        @DeleteMapping("/patients/{id}")
//        public void deletePatientById(@PathVariable(value="id") Long patientId){
//               patientService.deletePatientById(patientId);
//        }
        
        

        
}
