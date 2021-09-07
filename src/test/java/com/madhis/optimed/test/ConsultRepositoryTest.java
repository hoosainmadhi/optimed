package com.madhis.optimed.test;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.repository.ConsultRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsultRepositoryTest {
	
	@Autowired
	private ConsultRepository consultRepository;
	

//	@Test
//    	public void saveConsult(){
//        Consult consult = Consult.builder()
//                .consultDate("2000/08/01")
//                .reservationNumber("M000000hamm")
//               // .patient_id(2315)
//		.build();
//        consultRepository.save(consult);
//    }

	
}
