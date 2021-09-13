
package com.madhis.optimed.repository;

import com.madhis.optimed.entity.Dispense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DispenseRepository extends JpaRepository<Dispense, Long>{

	
    //Native Query
    @Query(
            value = "select sum(d.price) from dispense d, consult c "
            		+ " where c.consult_id=d.consult_id "
            		+ "and  c.consult_id=?1 ",
            nativeQuery = true
    )
	float totalPerConsultId(Long consultId);

	
}

