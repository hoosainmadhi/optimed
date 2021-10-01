package com.madhis.optimed.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.madhis.optimed.dto.ReportDTO;
import com.madhis.optimed.entity.Dispense;
import com.madhis.optimed.repository.DispenseRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private DispenseRepository dispenseRepository;
	
	public String exportReport(Long consultId) throws FileNotFoundException, JRException{

		String path = "/home/hoosain/Workspaces/Spring/optimed/src/main/resources/templates/reports";
		List<ReportDTO> report = dispenseRepository.findInvoiceByConsultId(consultId);

		File file = ResourceUtils.getFile("classpath:OptimedReport.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(report);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Hoosain Madhi");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint,  "/tmp/Invoice.pdf");

		return "report generated in path : " + path;

	}



}
