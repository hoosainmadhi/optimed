package com.madhis.optimed.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
	 public String exportReport(Long consultId) throws FileNotFoundException, JRException;

}
