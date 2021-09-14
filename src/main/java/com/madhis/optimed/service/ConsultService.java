package com.madhis.optimed.service;

import com.madhis.optimed.entity.Consult;

public interface ConsultService {
    
    public Consult addConsult(Consult consult);
      
    public Consult findByConsultId(Long consultId);

	public void deleteConsultById(Long consultId);    
}
