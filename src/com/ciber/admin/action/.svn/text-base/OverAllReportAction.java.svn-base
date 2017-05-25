package com.ciber.admin.action;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ciber.admin.dao.OverAllReportDAOImpl;
import com.ciber.beans.ExcelBean;
import com.ciber.beans.ReportBean;
import com.ciber.beans.User;

public class OverAllReportAction extends Action{
	
	private static final long serialVersionUID = 1L;
	private final static String SUCCESS = "success";
	private static final String NONE = "none";
	
	public OverAllReportAction(){
		
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception{
    	
		ExcelBean bean=null;
		String appId =request.getParameter("appId");
		String fileName = request.getParameter("appName");
		String empLevel = (String)request.getSession().getAttribute("empLevel");
		String empComp = (String)request.getSession().getAttribute("empComp");
		
		User userDetails = (User) request.getSession().getAttribute("user");
		
    	ArrayList<String> headers = new ArrayList<String>();
    	if(appId!=null && !appId.isEmpty()){
    	 bean=new OverAllReportDAOImpl().getReports(appId,empLevel);
    	 headers.add("Questions");
 		headers.add("Competency");
 		headers.add("Sub Competency");
    	}
    	 else if(empComp!=null && empComp.equalsIgnoreCase("Competency")){
			bean = new OverAllReportDAOImpl().getCompetencyReport(empLevel, empComp,userDetails);
			bean.setEmpLevel(empLevel);
			headers.add("Competency");
			fileName="Competency";
			if (empLevel != null && !empLevel.equals(""))
				fileName = "Competency: "+empLevel;
		}else {
    		bean =new OverAllReportDAOImpl().getOverALLReports(empLevel,empComp,userDetails);
    		headers.add("Questions");
    		headers.add("Competency");
    		headers.add("Sub Competency");
    		fileName="OverAll Report";
    		if (empLevel != null && !empLevel.equals(""))
				fileName = "OverAll Report: "+empLevel;
		}
        headers.add("Never");
        headers.add("Some Times");
        headers.add("Often");
        headers.add("Always");
        headers.add("Never Percentage");
        headers.add("Some Times Percentage");
        headers.add("Often Percentage");
        headers.add("Always Percentage");
              
        try {
			if(exportToExcel("Report", headers,fileName,bean,response,empComp))
			return mapping.findForward(NONE);
		} catch (HPSFException e) {
			e.printStackTrace();
		}
        return mapping.findForward(SUCCESS);
    }
	
	public static boolean exportToExcel(String sheetName, ArrayList<String> headers, String fileName,ExcelBean beann,HttpServletResponse response,String empComp) throws HPSFException {
	    boolean success = false;
	    System.out.println("OverAllReportAction.exportToExcel()");
		HSSFWorkbook wb = new HSSFWorkbook();
	    HSSFSheet sheet = wb.createSheet(sheetName);
	    sheet.setColumnWidth(0, 20000);

	    HSSFCellStyle headerStyle = wb.createCellStyle();
	  //  headerStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
	    headerStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
	    headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    HSSFFont font = wb.createFont();
	    font.setFontName(HSSFFont.FONT_ARIAL);
	    font.setFontHeightInPoints((short) 11);
	    font.setColor(HSSFColor.BLUE.index);
	    headerStyle.setFont(font);
	    
	    headerStyle.setWrapText(true);
	    headerStyle.setBorderTop((short) 6);
	    headerStyle.setBorderBottom((short) 1);
	    headerStyle.setBorderRight((short) 1);
	    headerStyle.setBorderLeft((short) 1);

	    headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

	    
	    HSSFCellStyle colStyle = wb.createCellStyle();
	    colStyle.setFillBackgroundColor(IndexedColors.LIME.getIndex());
	    font.setFontHeightInPoints((short) 11);
	    colStyle.setFont(font);
	    
	    colStyle.setWrapText(true);
	    colStyle.setBorderTop((short) 6);
	    colStyle.setBorderBottom((short) 1);
	    colStyle.setBorderRight((short) 1);
	    colStyle.setBorderLeft((short) 1);
	    
	    int rowIdx = 0;
	    
	    //Questions Header
	    HSSFRow hssfQuestionsHeader = sheet.createRow(rowIdx);
	    HSSFCell questionsHeaderCell;
	    HSSFCell questionsHeaderCell2;
	    questionsHeaderCell = hssfQuestionsHeader.createCell(0);
	    questionsHeaderCell2 = hssfQuestionsHeader.createCell(1);
	    HSSFCellStyle headerStyles = wb.createCellStyle();
	    headerStyles.setFillForegroundColor(HSSFColor.WHITE.index);
	    headerStyles.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    HSSFFont fonts = wb.createFont();
	    fonts.setFontName(HSSFFont.FONT_ARIAL);
	    fonts.setFontHeightInPoints((short) 11);
	    fonts.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    fonts.setColor(HSSFColor.BLACK.index);
	    headerStyles.setFont(fonts);
	    questionsHeaderCell.setCellValue("Total Number of Reflections:  "+beann.getTotalReflections());
	    questionsHeaderCell.setCellStyle(headerStyles);
	    questionsHeaderCell2.setCellValue("Total Number of Respondents:  "+beann.getNoOfRespondents()+" (" + beann.getNoOfNotRespondents()+"%)");
	    questionsHeaderCell2.setCellStyle(headerStyles);
        rowIdx++;
        hssfQuestionsHeader = sheet.createRow(rowIdx);
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
	    culumnStyle.setBorderTop((short) 6);
	    culumnStyle.setBorderBottom((short) 1);
	    culumnStyle.setBorderRight((short) 1);
	    culumnStyle.setBorderLeft((short) 1);
	    culumnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	                    
	    for (ReportBean registrationBean : beann.getAnsbean()) {
	    	row=sheet.createRow(rowIdx++);
	    	if(empComp==null ){
		    	column= row.createCell(0);
				if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
					column.setCellStyle(culumnStyle);
					column.setCellValue(registrationBean.getQuestionName());
				}
				column= row.createCell(2);
				if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
					column.setCellStyle(culumnStyle);
					column.setCellValue(registrationBean.getSubCompetency());
				}
	    	}
	    	column= row.createCell((empComp!=null)?0:1);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getCompetency());
			}
			column= row.createCell((empComp!=null)?1:3);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getNever()+"");
			}
			column= row.createCell((empComp!=null)?2:4);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getSomeTimes()+"");
			}
			column= row.createCell((empComp!=null)?3:5);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getOften()+"");
			}
			column= row.createCell((empComp!=null)?4:6);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getAlways()+"");
			}
			column= row.createCell((empComp!=null)?5:7);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getNeverPercentage()+"");
			}
			column= row.createCell((empComp!=null)?6:8);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getSomeTimesPercentage()+"");
			}
			column= row.createCell((empComp!=null)?7:9);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getOftenPercentage()+"");
			}
			column= row.createCell((empComp!=null)?8:10);
			if (column.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
				column.setCellStyle(culumnStyle);
				column.setCellValue(registrationBean.getAlwaysPercentage()+"");
			}
	    }
	    wb.setSheetName(0, sheetName);
                try 
        {
        	ByteArrayOutputStream outByteStream = new ByteArrayOutputStream(); 
        	wb.write(outByteStream); 
        	byte [] outArray = outByteStream.toByteArray(); 
        	response.setContentType("application/ms-excel"); 
        	response.setContentLength(outArray.length); 
        	response.setHeader("Expires:", "0"); // eliminates browser caching 
        	response.setHeader("Content-Disposition", "attachment; filename="+fileName+".xls"); 
        	OutputStream outStream = response.getOutputStream(); 
        	outStream.write(outArray); 
        	outStream.flush(); 
        	success = true;
        } 
        catch (IOException e) 
        {
            throw new HPSFException(e.getMessage());
        }
		return success;
	}
}
    
