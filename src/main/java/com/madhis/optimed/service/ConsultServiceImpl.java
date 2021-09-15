package com.madhis.optimed.service;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.entity.Script;
import com.madhis.optimed.repository.ConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultServiceImpl implements ConsultService {   
	
    @Autowired
    private ConsultRepository consultRepository;
    
    @Override
    public Consult addConsult(Consult consult){
	//set  patientId before saving consult object
        	
	return consultRepository.save(consult);
	}

    @Override
    public Consult findByConsultId(Long consultId){
    	return consultRepository.findByConsultId(consultId);
	
    }    
    @Override
	public void deleteConsultById(Long consultId) {
    	       consultRepository.deleteById(consultId);
    }
    
    @Override
    public void updateConsult(Long consultId, Consult consult) {   
		Consult consultFromDb = consultRepository.findByConsultId(consultId);
		System.out.println("consultFromDb = " + consultFromDb);
		consultFromDb.setConsultDate(consult.getConsultDate());
		consultFromDb.setReservationNumber(consult.getReservationNumber());
		consultRepository.save(consultFromDb);
    } 
}
