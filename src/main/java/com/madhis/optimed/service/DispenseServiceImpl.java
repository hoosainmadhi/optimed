package com.madhis.optimed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.madhis.optimed.repository.DispenseRepository;
import com.madhis.optimed.entity.Dispense;

@Service
public class DispenseServiceImpl implements DispenseService {   

	@Autowired
	private DispenseRepository dispenseRepository;

	@Override
	public Dispense addDispense(Dispense dispense){
		return dispenseRepository.save(dispense);
	}

	@Override
	public java.lang.Float totalPerConsultId(Long consultId) {
		return dispenseRepository.totalPerConsultId(consultId);
	}

	@Override
	public void deleteDispenseById(Long dispenseId) {
		 dispenseRepository.deleteById(dispenseId);
	} 
	
}
