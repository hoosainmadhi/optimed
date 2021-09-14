package com.madhis.optimed.service;

import com.madhis.optimed.entity.Dispense;

public interface DispenseService {
	
	public Dispense addDispense(Dispense dispense);
	
	public java.lang.Float totalPerConsultId(Long consultId);

	public void deleteDispenseById(Long dispenseId); 
}
