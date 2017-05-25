package com.ciber.report.test;

import java.util.ArrayList;

import com.ciber.admin.action.ReadExcel;
import com.ciber.admin.dao.AdminQuestionDAOImpl;
import com.ciber.admin.form.QuestionModel;

public class QuestionsUploadTest {
public static void main(String[] args) {
	try {
		ArrayList<QuestionModel> questions=new ReadExcel().getQuestionDetails("C:\\","QuestionsTemplate.xls");
		AdminQuestionDAOImpl aqd=new AdminQuestionDAOImpl();
		if(questions!=null){
			int result=0;
			String appType="";
			String ans1,ans2,ans3,ans4;
			boolean notMultipleChoice=false;

			if(questions.size() > 0)
			{
				
					for(QuestionModel question: questions)
					{
						ans1=question.getAns1();
						ans2=question.getAns2();
						ans3=question.getAns3();
						ans4=question.getAns4();

						if((ans1.equalsIgnoreCase("NA") || ans1.equalsIgnoreCase("")) && (ans2.equalsIgnoreCase("NA") || ans2.equalsIgnoreCase("")) && (ans3.equalsIgnoreCase("NA") || ans3.equalsIgnoreCase("")) && (ans4.equalsIgnoreCase("NA") || ans4.equalsIgnoreCase("")))
						{
							System.out.println("Invalid options");
							notMultipleChoice=true;
							break;
						}
					}
				if(!notMultipleChoice)
				{
					for(QuestionModel obj : questions)
						result=aqd.addQuestion(obj);
					if(result==1)
					{
						int insrt;
						//insrt = aqd.appCreated(appId);
						//if(insrt==1)
							System.out.println("Questions updated successfully.");
					}
						
					else
						System.out.println("unable to upload.");
				}
			}
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
