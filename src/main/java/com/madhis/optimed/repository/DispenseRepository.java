
package com.madhis.optimed.repository;

import com.madhis.optimed.entity.Dispense;

import java.util.List;

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
    			    + "	and c.consult_id=9 ", 
    	    nativeQuery = true
    )
	List<Dispense> findDispensesByConsultId(Long consultId);


	
}

