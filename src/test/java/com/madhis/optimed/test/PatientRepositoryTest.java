package com.madhis.optimed.test;

import com.madhis.optimed.entity.Consult;
import com.madhis.optimed.entity.Patient;
import com.madhis.optimed.repository.PatientRepository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PatientRepositoryTest {
    
    @Autowired
    private PatientRepository patientRepository;


    	
//    @Test
//    public void savePatient(){
//
//	Consult consult = Consult.builder()
//		.consultDate("2020/01/01")
//		.reservationNumber("DISC001")
//		.build();
//	
//        Patient patient = 
//		Patient.builder()
//	                .patientName("Mohammed Madhi")
//        	        .patientNumber("M000000hamm")
//                	.medicalAid("Genesis")
//	                .medicalAidNumber("2445fff")
//			.consults(List.of(consult))
//        	        .build();
//        patientRepository.save(patient);
//    }
//    
//    @Test
//    public void printAllPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//        System.out.println("patientList=" + patientList);
//    }
//    
//    @Test
//    public void printPatientByPatientName(){
//        List<Patient>  patients =
//                patientRepository.findByPatientName("Hoosain Madhi");
//        
//        System.out.println("patient =" + patients);
//    }
//   
//    
//    @Test
//    public void printgetPatientByPatientNumber(){
//        Patient patient =
//                patientRepository.getPatientByPatientNumber("M001");
//        System.out.println("patient =" + patient);
//
//    }
//    
//    @Test
//    public void printgetPatientByPatientNumberNative(){
//        Patient patient =
//                patientRepository.getPatientByPatientNumberNative("M001");
//        System.out.println("patient =" + patient);
//    }
}
