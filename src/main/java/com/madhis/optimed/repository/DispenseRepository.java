package com.madhis.optimed.repository;

import com.madhis.optimed.dto.ReportDTO;
import com.madhis.optimed.entity.Dispense;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DispenseRepository extends JpaRepository<Dispense, Long>{

	
	
    //Native Query
    @Query(
            value = "select sum(d.price) from dispense d, consult c "
            		+ " where c.consult_id=d.consult_id "
            		+ "and  c.consult_id=?1 ",
            nativeQuery = true
    )
	java.lang.Float totalPerConsultId(Long consultId);


    //Native Query
    @Query(
    		value = "SELECT d.* from consult c ,dispense d " 
    				+ " where c.consult_id = d.consult_id " 
    			    + "	and c.consult_id=1? ", 
    	    nativeQuery = true
    )
	List<Dispense> findDispensesByConsultId(Long consultId);

	
    //Invoice - Native Query does not work with ReportDTO - require JPQL 
    @Query(
    		value = "SELECT p.*, c.*, s.*, d.* from patient p, consult c ,script s,dispense d "
    				+ " where p.patient_id=c.patient_id "
    				+ " and c.consult_id = d.consult_id " 
    				+ " and c.fk_script_id =s.script_id"
    			    + "	and c.consult_id=?1 ", 
    	    nativeQuery = true
    )
	List<Dispense> findInvByConsultId(Long consultId);
    
    @Query("SELECT new com.madhis.optimed.dto.ReportDTO("
    		+ " p.patientName, p.patientNumber, p.medicalAid, p.medicalAidNumber, p.dob, p.principalMember, "
    		+ " c.consultDate, c.reservationNumber, "
    		+ " s.leftEye, s.rightEye, s.addition, s.pd, "
    		+ " d.icd10, d.tariffCode, d.dispenseItem, d.price) "
    		+ " from Patient p "
    		+ " JOIN p.consults c "
    		+ " JOIN c.dispenses d "
    		+ " JOIN c.script s"
    		+ " where c.consultId =  :consultId  " )
    List<ReportDTO> findInvoiceByConsultId(Long consultId);

    
}

