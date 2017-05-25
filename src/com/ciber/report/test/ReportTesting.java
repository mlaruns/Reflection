package com.ciber.report.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.ciber.admin.dao.OverAllReportDAOImpl;
import com.ciber.beans.ExcelBean;
import com.ciber.beans.ReportBean;

public class ReportTesting {
public static void main(String[] args) {
	
	    	String appId ="230";
	    	OverAllReportDAOImpl overAllReportDao = new OverAllReportDAOImpl();
	    	ExcelBean bean=new OverAllReportDAOImpl().getReports("230",null);
	        ArrayList<String> headers = new ArrayList<String>();
			String fileName = "Test";
			headers.add("Questions");
	        headers.add("Never");
	        headers.add("Some Times");
	        headers.add("Often");
	        headers.add("Always");
	       
	      
	        try {
				exportToExcel("Test", headers,fileName,bean);
			} catch (HPSFException e) {
				e.printStackTrace();
			}
	
	
	
}
public static boolean exportToExcel(String sheetName, ArrayList<String> headers, String fileName,ExcelBean beann) throws HPSFException {
    boolean success = false;
    System.out.println("OverAllReportAction.exportToExcel()");
	HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet(sheetName);

    HSSFCellStyle headerStyle = wb.createCellStyle();
    headerStyle.setFillBackgroundColor(IndexedColors.LIME.getIndex());
    HSSFFont font = wb.createFont();
    font.setFontName(HSSFFont.FONT_ARIAL);
    font.setFontHeightInPoints((short) 10);
    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    font.setColor(HSSFColor.BLUE.index);
    headerStyle.setFont(font);
    
    headerStyle.setWrapText(true);
    headerStyle.setBorderTop((short) 6);
    headerStyle.setBorderBottom((short) 1);
    headerStyle.setBorderRight((short) 1);
    headerStyle.setBorderLeft((short) 1);

    headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

    int rowIdx = 0;
    short cellIdx = 0;

    
    //Questions Header
    HSSFRow hssfQuestionsHeader = sheet.createRow(rowIdx);
    HSSFCell questionsHeaderCell;
   int num=0;
    for (String questionsHeader : headers) {
    	questionsHeaderCell = hssfQuestionsHeader.createCell(num);
        questionsHeaderCell.setCellValue(questionsHeader);
        questionsHeaderCell.setCellStyle(headerStyle);
        num++;
	}
    
 
    rowIdx++;

    HSSFRow row;
    HSSFCell column;
    HSSFCellStyle culumnStyle = wb.createCellStyle();
    culumnStyle.setWrapText(true);
    culumnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                    
    for (ReportBean registrationBean : beann.getAnsbean()) {
    	row=sheet.createRow(rowIdx++);
    	column= row.createCell(0);
		if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
			column.setCellStyle(culumnStyle);
			column.setCellValue(registrationBean.getQuestionName());
		}
		if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
			column.setCellStyle(culumnStyle);
			column.setCellValue(registrationBean.getNever());
		}
		if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
			column.setCellStyle(culumnStyle);
			column.setCellValue(registrationBean.getOften());
		}
		if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
			column.setCellStyle(culumnStyle);
			column.setCellValue(registrationBean.getSomeTimes());
		}
		if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
			column.setCellStyle(culumnStyle);
			column.setCellValue(registrationBean.getAlways());
		}
    }
wb.setSheetName(0, sheetName);
    try{
    FileOutputStream out = 
            new FileOutputStream(new File("C:\\formula.xls"));
    wb.write(out);
    out.close();
    }catch(Exception exp ){
    	exp.printStackTrace();
    }
    System.out.println("Excel written successfully..");
		
	return success;
}
}