package com.madhis.optimed.service;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;

public interface ConsultService {
    
    public Consult addConsult(Consult consult);
      
    public Consult findByConsultId(Long consultId);

	public void deleteConsultById(Long consultId);    
	
    public void updateConsult(Long id, Consult consult);

}
