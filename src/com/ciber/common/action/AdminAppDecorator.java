package com.ciber.common.action;

import org.displaytag.decorator.TableDecorator;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.User;
import com.ciber.beans.UserApplicationList;

public class AdminAppDecorator extends TableDecorator
{
	public String getStop()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		String link = "<a href=adminApplication.do?action=stop&appId="+ appModel.getAppId() +">Stop"+"</a>";
		return link;
	}
	public String getFeedbackdownload()
	{
		User appModel = (User) getCurrentRowObject();
		String link = "";
		if(appModel.getIsSurveyCreated()){
			link = "<a href=adminApplication.do?action=feedBack&employeeno="+ appModel.getEmployeeId() +">View Feed Back"+"</a>";
		}
		
		return link;
	}
	
	public String getFeedBack()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		String link = "";
			link = "<a href=adminApplication.do?action=feedBack&employeeno="+ appModel.getEmployeeID() +">View Feed Back"+"</a>";
		
		return link;
	}
	
	public String getTeam()
	{
		User appModel = (User) getCurrentRowObject();
		String link="";
		if(appModel.getIsReporties()){
		link = "<a href=adminApplication.do?action=veiwReporties&employeeno="+ appModel.getEmployeeId() +">Team"+"</a>";
		}
		return link;
	}
/*	public String getExtend()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		String link = "<a href=adminApplication.do?action=extend&appId="+ appModel.getAppId() +">Extend"+"</a>";
		return link;
	}*/
	public String getEditApp()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		String link = "<a href=adminApplication.do?action=editApp&appId="+ appModel.getAppId() +">Edit"+"</a>";
		return link;
	}
	public String getDelete()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		String link = "<a href=adminApplication.do?action=deleteApp&appId="+ appModel.getAppId() +"&appName="+appModel.getAppName()+" onclick='return confirmDelete();'>Delete"+"</a>";
		return link;
	}
	
	public String getCompletedFlag()
	{
		String link="";
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		if(appModel.getCompletedFlag().equalsIgnoreCase("completed"))
		link = "completed";
		else
			link=appModel.getCompletedFlag();	
		return link;
	}
	
	public String getUserappName()
	{
		String link="";
		UserApplicationList appModel = (UserApplicationList) getCurrentRowObject();
		link = "<a href=displayQuestion.do?appId="+ appModel.getAppId()+"&appType="+appModel.getUserappType() +"&role="+appModel.getRole()+">"+appModel.getUserappName()+"</a>";
		return link;
	}
	public String getDownload()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		String link = "";
			link = "<a href=adminApplication.do?action=feedBack&employeeno="+ appModel.getEmployeeID() +">Download"+"</a>";
			return link;
	}
	public String getView()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		//String link = "<input type='submit' name='overall' value='Download' />";
		String link = "<a href=adminApplication.do?action=viewSurvey&appId="+ appModel.getAppId()+"&appName="+appModel.getAppName()+">View</a>";
		return link;
	}
	public String getDownloadReports()
	{
		ApplicationModel appModel = (ApplicationModel) getCurrentRowObject();
		//String link = "<input type='submit' name='overall' value='Download' />";
		String link = "<a href=overAllReport.do?appId="+ appModel.getAppId()+"&appName="+appModel.getAppName()+">Download</a>";
		return link;
	}
	
}