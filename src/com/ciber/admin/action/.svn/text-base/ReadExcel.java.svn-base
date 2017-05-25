package com.ciber.admin.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.ciber.admin.form.QuestionModel;
import com.ciber.dao.DaoFactory;
import com.ciber.dao.QuestionsDAO;
import com.ciber.exception.ExcelException.ExcelException;

public class ReadExcel
{
	HashMap<Integer, Integer> headerDetails;
	int rows;
	int columns;
	String path;
	Map<String,String> questionMap=null;

	/**
	 * @param args
	 */
	public ArrayList<QuestionModel> getQuestionDetails(String path, String fileName) throws Exception
	{
		Workbook workbook;
		this.path = path;
		workbook = Workbook.getWorkbook(new File(path +"/"+ fileName));
		Sheet sheet = workbook.getSheet(0);
		rows = sheet.getRows();
		if(rows!=0){
		readHeader(sheet);
		return readContent(sheet);
		}else
		{
			return null;
		}


	}

	private ArrayList<QuestionModel> readContent(Sheet sheet) 
	{
		ArrayList<QuestionModel> bulkQuestionsList= new ArrayList<QuestionModel>();
		QuestionsDAO questionDAO=DaoFactory.getQuesDao();
		questionMap=questionDAO.getAllQuestions();
		
		QuestionModel bulkQuestions;
		Cell individualCell;
		String cellContent;
		int columnChoice;
		boolean invalidQuestion=false;
		Set<String> questions=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		columns=headerDetails.size();

		outerLoop: for (int i = 1; i < rows ; i++)
		{
			invalidQuestion=false;
			bulkQuestions=new QuestionModel();

			innerLoop: for (int j = 0; j < columns; j++)
			{
				individualCell = sheet.getCell(j, i);
				cellContent = individualCell.getContents();

				columnChoice = headerDetails.containsKey(j) ? (int)headerDetails.get(j):0;

				switch(columnChoice)
				{
				case 1: 
						if(!(cellContent.equalsIgnoreCase("EOF"))){
						if(!questions.contains(cellContent)){
							bulkQuestions.setQuestion(cellContent);
							questions.add(cellContent);
							}else{
								break innerLoop;
							}
						}
						else{
							invalidQuestion=true;
						}
					break;
				case 2:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setPriority(cellContent);
					else
						invalidQuestion=true;
					break;
				case 3:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setDescription(cellContent);
					else
						invalidQuestion=true;
					break;
				case 4: 
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setCompetency(cellContent);
					else
						invalidQuestion=true;
					
					break;
				case 5: 
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setSubCompetency(cellContent);
					else
						invalidQuestion=true;
					
					break;

				case 6:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setAns1(cellContent);
					else
						invalidQuestion=true;
					
					break;

				case 7: 
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setAns2(cellContent);
					else
						invalidQuestion=true;
					break;

				case 8: 
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setAns3(cellContent);
					else
						invalidQuestion=true;
					break;

				case 9:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setAns4(cellContent);
					else
						invalidQuestion=true;
					break;
					
				case 10:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setPeer1(cellContent);
					else
						invalidQuestion=true;
					break;
					
				case 11:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setPeer2(cellContent);
					else
						invalidQuestion=true;
					break;
					
				case 12:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setHr(cellContent);
					else
						invalidQuestion=true;
					break;
				case 13:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setIt(cellContent);
					else
						invalidQuestion=true;
					break;
				case 14:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setCrossfunctional(cellContent);
					else
						invalidQuestion=true;
					break;
				case 15:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setAdmin(cellContent);
					else
						invalidQuestion=true;
					break;
				case 16:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setQmo(cellContent);
					else
						invalidQuestion=true;
					break;
				case 17:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setFinance(cellContent);
					else
						invalidQuestion=true;
					break;
				case 18:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setRecruitment(cellContent);
					else
						invalidQuestion=true;
					break;
				case 19:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setRmg(cellContent);
					else
						invalidQuestion=true;
					break;
				case 20:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setReportee(cellContent);
					else
						invalidQuestion=true;
					break;
				case 21:
					if(!(cellContent.equalsIgnoreCase("EOF")))
						bulkQuestions.setSupervisor(cellContent);
					else
						invalidQuestion=true;
					break;
	
				}
			 	

				if(invalidQuestion)
				{
					System.out.println("Invalid question : "+i);
					break outerLoop;
				}
			}
				if(questions!=null){
				String questionID=questionMap.get(bulkQuestions.getQuestion());
				if(questionID!=null)
				bulkQuestions.setQuesID(Integer.valueOf(questionID));
			}
				bulkQuestionsList.add(bulkQuestions);
		}
			
		return bulkQuestionsList;
	}

	public void readHeader(Sheet sheet) throws ExcelException
	{
		int i;

		try
		{
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com/ciber/properties/questionheader.properties");  
			Properties pro = new Properties();
			pro.load(inputStream);
			Set<?> keySet = pro.keySet();
			
			if (keySet == null || keySet.size() == 0)
				throw new ExcelException("Invalid header entries found!");
			else
			{
				headerDetails = new HashMap<Integer, Integer>();

				columns=keySet.size();
				for (i = 0; i < columns; i++)
				{
					Cell a1 = sheet.getCell(i, 0);
					if (a1.equals("") || a1.equals(null) || a1 == null || a1.getContents() == "")
							continue;
					
					String stringa1 = a1.getContents();
					for (Object value : keySet)
					{
						Integer keyValue = Integer.parseInt((String)value);
						if (pro.getProperty(keyValue.toString()).equalsIgnoreCase(stringa1))
						{
							headerDetails.put(i, keyValue);
							break;
						}
					}
				}
			}
			if (!(headerDetails.size() == keySet.size()))
				throw new ExcelException("Please use proper excel file template");
		}

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new ExcelException("Invalid header entries found!");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			throw new ExcelException("Invalid header entries found!");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		ReadExcel r = new ReadExcel();
		ArrayList<QuestionModel> ar=r.getQuestionDetails("C:\\","QuestionsTemplate.xls");
		System.out.println("Question ID    Question       SecType");
		System.out.println("=========================================");
		for(QuestionModel ob : ar)
		{
			System.out.println(ob.getQmo()+"                "+ob.getQuesID()+"         "+ob.getFinance()+"    ");
		}
	}
}