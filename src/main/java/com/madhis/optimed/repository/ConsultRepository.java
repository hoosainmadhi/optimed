package com.madhis.optimed.repository;

import com.madhis.optimed.entity.Consult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long>{

	public List<Consult> findByConsultDate(String consultDate);
	
	public Consult findConsultByConsultId(Long consultId);
	
	

}
