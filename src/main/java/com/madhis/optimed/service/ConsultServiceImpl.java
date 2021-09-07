package com.madhis.optimed.service;

import com.madhis.optimed.entity.Consult;
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
    	return consultRepository.findConsultByConsultId(consultId);
	
    }    
}
