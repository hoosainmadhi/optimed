package com.madhis.optimed.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
	
	private String patientName;
    private String patientNumber;
    private String medicalAid; 
    private String medicalAidNumber;
    private Date dob;
    private String principalMember;
    private Date consultDate;
    private String reservationNumber;
    private String leftEye;
    private String rightEye;
    private String addition;
    private String pd;
	private String icd10;
	private String tariffCode;
    private String dispenseItem;
    private float price;
}
