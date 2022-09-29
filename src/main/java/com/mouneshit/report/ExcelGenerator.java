package com.mouneshit.report;

import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.mouneshit.binding.SearchResponse;

public class ExcelGenerator {
	
	public void generateExcel(List<SearchResponse> response, HttpServletResponse httpResponse) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Sl.No");
		headerRow.createCell(1).setCellValue("Holder Name");
		headerRow.createCell(2).setCellValue("Holder SSN");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amt");
		headerRow.createCell(8).setCellValue("Denial Reason");
		
		for(int i=1;i<response.size();i++) {
			HSSFRow dataRow = sheet.createRow(i);
			SearchResponse resp = response.get(i-1);
			dataRow.createCell(0).setCellValue(i);
			dataRow.createCell(1).setCellValue(resp.getHolderName());
			dataRow.createCell(2).setCellValue(resp.getHolderSSN());
			dataRow.createCell(3).setCellValue(resp.getPlanName());
			dataRow.createCell(4).setCellValue(resp.getPlanStatus());
			dataRow.createCell(5).setCellValue(String.valueOf(resp.getStartDate()));
			dataRow.createCell(6).setCellValue(String.valueOf(resp.getEndDate()));
			dataRow.createCell(7).setCellValue(resp.getBenefitAmt());
			dataRow.createCell(7).setCellValue(resp.getDenialReason());
			
		}
		
		workbook.write(httpResponse.getOutputStream());
		workbook.close();
	}

}
