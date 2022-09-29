package com.mouneshit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouneshit.binding.SearchRequest;
import com.mouneshit.binding.SearchResponse;
import com.mouneshit.report.ExcelGenerator;
import com.mouneshit.report.PDFGenerator;
import com.mouneshit.service.ReportService;

@RestController
public class ReportRestController {
	
	@Autowired
	private ReportService service;
	
	
	@PostMapping("/search")
	public List<SearchResponse> searchPlans(@RequestBody SearchRequest request){
		return service.search(request);
	}
	
	@GetMapping("/plannames")
	public List<String> getPlanNames(){
		return service.loadPlan();
	}
	
	@GetMapping("/planstatus")
	public List<String> getPlanStatus(){
		return service.loadPlanStatus();
	}
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);
		
		List<SearchResponse> records = service.search(null);
		ExcelGenerator excel = new ExcelGenerator();
		excel.generateExcel(records, response);
	}
	
	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		response.setHeader(headerKey, headerValue);
		
		List<SearchResponse> records = service.search(null);
		PDFGenerator pdf = new PDFGenerator();
		pdf.generatePdf(records, response);
	}
	
	

}
