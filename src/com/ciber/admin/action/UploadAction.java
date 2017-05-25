package com.ciber.admin.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import com.ciber.admin.dao.AdminQuestionDAOImpl;
import com.ciber.admin.form.FileUploadForm;
import com.ciber.admin.form.QuestionModel;
import com.ciber.exception.ExcelException.ExcelException;

public class UploadAction extends Action
{
	private final static String SUCCESS = "success";
	
	ActionMessages errors=new ActionMessages();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		FileUploadForm uploadForm = (FileUploadForm) form;
		FileOutputStream outputStream = null;
		FormFile formFile = null;
		File newFile = null;
		String message="";
		String fileName="";
		String returnValue="failure";
		//int appId=(Integer)request.getSession().getAttribute("applicationId");
		//String fileType="";
		try
		{
			formFile = uploadForm.getFile();
			fileName = formFile.getFileName();
			int ext = fileName.lastIndexOf('.')+1;
			String extNme = fileName.substring(ext);
			
			if (formFile.getFileSize() == 0)
				message="Please select a file to upload.";
				//errors.add("file", new ActionMessage("error.file.required"));
			//|| formFile.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
		//	else if (!(formFile.getContentType().equals("application/vnd.ms-excel") ))
			//	message="Please select only .xls(Excel 2003 version) file to upload.";
				//errors.add("file", new ActionMessage("error.file.type"));
			 else if (!(extNme.equals("xls")))
					message="Please select only .xls(Excel 2003 version) file to upload.";

			else
			{
				try
				{
					String path = getServlet().getServletContext().getRealPath("/")+"upload";

					//Check for the specified folder "upload" in the path. If not exists create one.
					newFile = new File(path);
					if(!newFile.exists())
						newFile.mkdir();

					//fileName=formFile.getFileName();

					newFile = new File(path, fileName);
					FileOutputStream fos = new FileOutputStream(newFile);
					fos.write(formFile.getFileData());
					fos.flush();
					fos.close();
					ArrayList<QuestionModel> questions=null;
					try{
					 questions=new ReadExcel().getQuestionDetails(path, fileName);
					}catch(ArrayIndexOutOfBoundsException e){
						
					}
					AdminQuestionDAOImpl aqd=new AdminQuestionDAOImpl();
					int result=0;
					String appType="";
					String ans1,ans2,ans3,ans4;
					boolean notMultipleChoice=false;
					if(questions!=null){

					if(questions.size() > 0)
					{
						appType=(String) request.getSession().getAttribute("appTypeCheck");
						
							for(QuestionModel question: questions)
							{
								ans1=question.getAns1();
								ans2=question.getAns2();
								ans3=question.getAns3();
								ans4=question.getAns4();

								if((ans1.equalsIgnoreCase("NA") || ans1.equalsIgnoreCase("")) && (ans2.equalsIgnoreCase("NA") || ans2.equalsIgnoreCase("")) && (ans3.equalsIgnoreCase("NA") || ans3.equalsIgnoreCase("")) && (ans4.equalsIgnoreCase("NA") || ans4.equalsIgnoreCase("")))
								{
									message="Only multiple choice questions allowed for Quiz.";
									notMultipleChoice=true;
									break;
								}
							}
						if(!notMultipleChoice)
						{
							for(QuestionModel obj : questions){
								if(obj.getQuesID()==0){
								result=aqd.addQuestion(obj);
								}else{
									result=aqd.updateQuestion(obj);
								}
							}
							if(result==1)
							{
								//int insrt;
								/*insrt = aqd.appCreated(appId);
								if(insrt==1)*/
								message="Questions updated successfully.";
								request.getSession().setAttribute("message", "Survey sucessfully created...");
								returnValue="success";
							}
								
							else
								message="Unable to insert questions.";
						}
					}
					}
					else
						message="Please select a file which has some Questions to upload";
				}
				catch (ExcelException e)
				{
					message=e.getMessage();
				}
			}
		}
		finally
		{
			if (outputStream != null)
				outputStream.close();
			if(null !=newFile && newFile.exists())
				newFile.delete();
		}
		request.setAttribute("message", message);
		return mapping.findForward(returnValue);}
}