package com.ciber.admin.uploadxls;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ciber.beans.EmployeeDetails;
import com.ciber.beans.MgrPeerInfo;
import com.ciber.dao.DaoFactory;
import com.ciber.template.Dbconnection;

public class UploadManagerData {
	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/ciber/properties/uploadManagerDetails.properties");
	private List<String> headersRow=new ArrayList<String>();
	private List<String> headersRow2=new ArrayList<String>();
	public UploadManagerData(){
		headersRow.add("Manager employee ID");
		headersRow.add("Manager Name");
		headersRow.add("Peer 1");
		headersRow.add("");
		headersRow.add("Peer 2");
		headersRow.add("");
		headersRow.add("Corss Functional/practice");
		headersRow.add("");
		headersRow2.add("");
		headersRow2.add("");
		headersRow2.add("Name");
		headersRow2.add("email ID");
		headersRow2.add("Name");
		headersRow2.add("email ID");
		headersRow2.add("Name");
		headersRow2.add("email ID");
	}
	
	public static void main(String[] args) {
		/*List<EmployeeDetails> employeesDetails =new UploadManagerData().getManagersDetails(null,null);
		DaoFactory.getUpdateManagerInfoDAO().updateManagerInfo(employeesDetails);
		
		List<MgrPeerInfo> updatePeer =new UploadManagerData().readPeerData(null,null);
		DaoFactory.getUpdateManagerInfoDAO().updatePeerInfo(updatePeer);*/
	}
	
	
	public List<MgrPeerInfo> readPeerData(String path, String fileName) 
	{
		List<MgrPeerInfo> employeesDetails=new ArrayList<MgrPeerInfo>();
		try
		{
			FileInputStream file = new FileInputStream(new File(path +"/"+ fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheet("Mgr-Peer");
			if(sheet==null){
				return null;
			}
			
			boolean flag=readHeaderPeer(sheet);
			if(!flag){
				System.err.println("invalid header");
				return null;
			}
			int rows=sheet.getLastRowNum();
			int firstRow = sheet.getFirstRowNum();
			
			outerloop: for (int i = firstRow+2; i <= rows ; i++)
			{
				MgrPeerInfo mgrPeerInfo = new MgrPeerInfo();
				HSSFRow	individualRow = sheet.getRow(i);
				int firstcellnum = individualRow.getFirstCellNum();
				int lastcellnum = individualRow.getLastCellNum();
				int cellno=0;
				for(int j=firstcellnum;j<lastcellnum;j++){
						HSSFCell individualCell = individualRow.getCell(j);
				if(individualCell!=null){
				switch(cellno)
				{
				case 0: 
						if( individualCell.getCellType()==1){
							mgrPeerInfo.setManagerId(individualCell.getStringCellValue());
						}
						if( individualCell.getCellType()==0){
							Double d=individualCell.getNumericCellValue();
							if(d!=null){
							Integer num=d.intValue();
							mgrPeerInfo.setManagerId(num.toString());
							}
						}
					break;

				case 1: 
						if( individualCell.getCellType()==1){
							mgrPeerInfo.setManagerName(individualCell.getStringCellValue());
						}
						if( individualCell.getCellType()==0){
							mgrPeerInfo.setManagerName(String.valueOf(individualCell.getNumericCellValue()));
						}
					break;
				case 2: 
					if( individualCell.getCellType()==1){
						mgrPeerInfo.setPeer1Name(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						mgrPeerInfo.setPeer1Name(String.valueOf(individualCell.getNumericCellValue()));
					}
				break;

				case 3:
					if( individualCell.getCellType()==1){
						mgrPeerInfo.setPeer1Email(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						mgrPeerInfo.setPeer1Email(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;

				case 4: 
					if( individualCell.getCellType()==1){
						mgrPeerInfo.setPeer2Name(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						mgrPeerInfo.setPeer2Name(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;

				case 5: 
					if( individualCell.getCellType()==1){
						mgrPeerInfo.setPeer2Email(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						mgrPeerInfo.setPeer2Email(individualCell.getStringCellValue().trim());
					}
					break;

				case 6:
					if( individualCell.getCellType()==1){
						mgrPeerInfo.setCrossFunctionalName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						mgrPeerInfo.setCrossFunctionalName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
					
				case 7:
					if( individualCell.getCellType()==1){
						mgrPeerInfo.setCrossFunctionalEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						mgrPeerInfo.setCrossFunctionalEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				}
				}
				cellno++;
				if(mgrPeerInfo.getManagerId()==null){
					break outerloop;
				}
				
				}
				System.out.println(mgrPeerInfo.getManagerId());
				employeesDetails.add(mgrPeerInfo);
				
			}
				
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return employeesDetails;
	}
	
	public List<EmployeeDetails> getManagersDetails(String path, String fileName) 
	{
		List<EmployeeDetails> employeesDetails=new ArrayList<EmployeeDetails>();
		try
		{
			FileInputStream file = new FileInputStream(new File(path +"/"+ fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheet("Mgr-Shared Service");
			if(sheet==null){
				return null;
			}
			boolean flag = readHeader(sheet);
			if(!flag){
				return null;
			}
			int rows=sheet.getLastRowNum();
			int firstRow = sheet.getFirstRowNum();
			
			outerloop: for (int i = firstRow+1; i < rows ; i++)
			{
				EmployeeDetails employeeDetails=new EmployeeDetails();
				HSSFRow	individualRow = sheet.getRow(i);
				int firstcellnum = individualRow.getFirstCellNum();
				int lastcellnum = individualRow.getLastCellNum();
				int dif=lastcellnum-firstcellnum;
				int cellno=1;
				for(int j=firstcellnum;j<lastcellnum;j++){
						HSSFCell individualCell = individualRow.getCell(j);
				if(individualCell!=null){	
				switch(cellno)
				{
				case 1: 
					if( individualCell.getCellType()==1){
						employeeDetails.setEmpId(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						Double d=individualCell.getNumericCellValue();
						if(d!=null){
						Integer num=d.intValue();
						employeeDetails.setEmpId(num.toString());
						}
					}
				break;

				case 2: 
						if( individualCell.getCellType()==1){
							employeeDetails.setEmpName(individualCell.getStringCellValue());
						}
						if( individualCell.getCellType()==0){
							employeeDetails.setEmpName(String.valueOf(individualCell.getNumericCellValue()));
						}
					break;
				case 3: 
					if( individualCell.getCellType()==1){
						employeeDetails.setPracticeName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setPracticeName(String.valueOf(individualCell.getNumericCellValue()));
					}
				break;

				case 4:
					if( individualCell.getCellType()==1){
						employeeDetails.setProjectName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setProjectName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;

				case 5: 
					if( individualCell.getCellType()==1){
						employeeDetails.setHrbpName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setHrbpName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;

				case 6: 
					if( individualCell.getCellType()==1){
						employeeDetails.setHrbpEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setHrbpEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;

				case 7:
					if( individualCell.getCellType()==1){
						employeeDetails.setAdminName(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setAdminName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
					
				case 8:
					if( individualCell.getCellType()==1){
						employeeDetails.setAdminEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setAdminEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
					
				case 9:
					if( individualCell.getCellType()==1){
						employeeDetails.setItName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setItName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
					
				case 10:
					if( individualCell.getCellType()==1){
						employeeDetails.setItEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setItEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 11:
					if( individualCell.getCellType()==1){
						employeeDetails.setQmoName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setQmoName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 12:
					if( individualCell.getCellType()==1){
						employeeDetails.setQmoEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setQmoEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 13:
					if( individualCell.getCellType()==1){
						employeeDetails.setFinanceName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setFinanceName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 14:
					if( individualCell.getCellType()==1){
						employeeDetails.setFinanceEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setFinanceEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 15:
					if( individualCell.getCellType()==1){
						employeeDetails.setRequitmentName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setRequitmentName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 16:
					if( individualCell.getCellType()==1){
						employeeDetails.setRequitmentEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setRequitmentEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 17:
					if( individualCell.getCellType()==1){
						employeeDetails.setRmgName(individualCell.getStringCellValue());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setRmgName(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				case 18:
					if( individualCell.getCellType()==1){
						employeeDetails.setRmgEmail(individualCell.getStringCellValue().trim());
					}
					if( individualCell.getCellType()==0){
						employeeDetails.setRmgEmail(String.valueOf(individualCell.getNumericCellValue()));
					}
					break;
				
				}
				}
				
				cellno++;
				}
				if(employeeDetails.getEmpId()==null){
					break outerloop;
				}
				System.out.println(employeeDetails.getEmpId());
				employeesDetails.add(employeeDetails);
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return employeesDetails;
	}
	
	public boolean readHeader(HSSFSheet sheet) throws Exception
	{
		
			Properties pro = new Properties();
			pro.load(inputStream);
			Set<?> keySet = pro.keySet();
			
			if (keySet == null || keySet.size() == 0)
				throw new Exception("property file ise ");
			else
			{
				int	firstRow = sheet.getFirstRowNum();
				HSSFRow	individualRow = sheet.getRow(firstRow);
				int firstcellnum = individualRow.getFirstCellNum();
				int lastcellnum = individualRow.getLastCellNum();
				Integer cellno=1;
				for(int j=firstcellnum;j<lastcellnum;j++){
						HSSFCell individualCell = individualRow.getCell(j);
						if (individualCell.getStringCellValue()!=null && individualCell.getStringCellValue().equalsIgnoreCase(pro.getProperty(cellno.toString()))){
							System.err.println(individualCell.getStringCellValue());
						}else{
							return false;
						}
						cellno++;
						
				}
				
			}
			
			return true;
		
	}

	
	public boolean readHeaderPeer(HSSFSheet sheet) 
	{
		
		int rows=sheet.getFirstRowNum()+2;
		int firstRow = sheet.getFirstRowNum();
		outerloop: for (int i = firstRow; i < rows ; i++)
		{
			HSSFRow	individualRow = sheet.getRow(i);
			int firstcellnum = individualRow.getFirstCellNum();
			int lastcellnum = individualRow.getLastCellNum();
			int dif=lastcellnum-firstcellnum;
			int count=0;
			for(int j=firstcellnum;j<lastcellnum;j++){
					HSSFCell individualCell = individualRow.getCell(j);
					if(individualCell!=null){
					if(i==firstRow){
						if(individualCell.getStringCellValue().equalsIgnoreCase(headersRow.get(count))){
							
						}else{
							return false;
						}
					}else{
						if(individualCell.getStringCellValue().equalsIgnoreCase(headersRow2.get(count))){
							
						}else{
							return false;
						}
						
					}
					}else{
						return false;
					}
					count++;
			}
		}
		return true;
	}
				
			
		
		
}
