package com.ciber.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ciber.admin.dao.AddEmployeeDAO;
import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.EmployeeList;
import com.ciber.beans.ImprovementOptions;
import com.ciber.beans.JohariWidowAdjectives;
import com.ciber.beans.Questions;
import com.ciber.beans.SurveyBean;
import com.ciber.beans.User;
import com.ciber.beans.UserApplicationList;
import com.ciber.dao.AdminAppDAO;
import com.ciber.dao.CheckDAO;
import com.ciber.dao.DaoFactory;
import com.ciber.dao.LoginDAO;
import com.ciber.dao.QuestionsDAO;

public class JDBCService {
	
	public User getUserDetails(User user){
		LoginDAO appDao = DaoFactory.getLoginDao();
		return appDao.getUserDetails(user);
	}
	
	public List<User> getReportiesDetails(String supervisorID){
		LoginDAO appDao = DaoFactory.getLoginDao();
		return appDao.getReportiesDetails(supervisorID);
	}

	public List<EmployeeList> getUsers(String employeeID){
		LoginDAO appDao = DaoFactory.getLoginDao();
		return appDao.getUsers(employeeID);
	}
	
	public Map<String,Questions> retrieveQuestions(String appId,String userID,String role){
		QuestionsDAO quesDao = DaoFactory.getQuesDao();
		return quesDao.questionList(appId,userID,role);
	}
	
	public List<JohariWidowAdjectives> getJohariWidowAdjectives(){
		QuestionsDAO quesDao = DaoFactory.getQuesDao();
		return quesDao.getJohariWidowAdjectives();
	}
	

	public String checkAnswerCount(String UserName,Map<String,Questions> answers, String applicationId){
		CheckDAO checkDao = DaoFactory.getCheckDao();
		return checkDao.checkAnswerCount(UserName,answers,applicationId);
	}
	
	public boolean insertAnswers(String username, Map<String,Questions> map,String applicationId){
		CheckDAO checkDao = DaoFactory.getCheckDao();
		return checkDao.insertAnswers(username, map,applicationId);
	}

	public boolean insertJohariAnswers(String username, String johariAns,String applicationId){
		CheckDAO checkDao = DaoFactory.getCheckDao();
		return checkDao.insertJohariAnswers(username, johariAns,applicationId);
	}
	
	
	public ArrayList<ApplicationModel> currentApplications(User userDetails){
		LoginDAO appDao=DaoFactory.getLoginDao();
		return appDao.currentApplications(userDetails);
	}
	
	public ArrayList<UserApplicationList> currentApplicationsUsr(User userDetails,String UserName){
		LoginDAO appDao=DaoFactory.getLoginDao();
		return appDao.currentApplicationsUsr(userDetails,UserName);
	}

	public boolean stopApplication(String appId) {
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		return adminAppDao.stopApplication(appId);
	}
	
	public ArrayList<ApplicationModel> viewFeedBack(String empId) {
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		return adminAppDao.viewFeedback(empId);
	}
	public ArrayList<ApplicationModel> viewRecentApplication(String startDate,String endDate) {
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		return adminAppDao.viewRecentApplication(startDate, endDate);
	}

	public int addApplication(SurveyBean bean)
	{
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		return adminAppDao.addApplication(bean);
	}
	
	public boolean updateApplicationStatus(String username, Map<String,Questions> map,String applicationId,String ans_count)
	{
		CheckDAO checkDao = DaoFactory.getCheckDao();
		return checkDao.updateApplicationStatus(username, map,applicationId,ans_count);
		
	}
	
	public int flagCheckUser(String applicationId,String empId,String role)
	{
		CheckDAO checkDao = DaoFactory.getCheckDao();
		return checkDao.flagCheckUser(applicationId, empId,role);
		
	}
	public boolean updateEmployeeCount(int count,String appID)
	{
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		adminAppDao.updateEmployeeCount(count,appID);
		return true;
		
	}
	

	public boolean addSurvey(EmployeeList employee,String appID)
	{
		AddEmployeeDAO employeeList=DaoFactory.addEmployeeList();
		return employeeList.addEmployeeList(employee,appID);
		
	}
	


	public List<Questions> getQuestions(String appId,String username,String role) {
		CheckDAO dao = DaoFactory.getCheckDao();
		return  dao.getQuestion(appId,username,role);
	}
	public String getJohariUserAns(String appId,String username) {
		CheckDAO dao = DaoFactory.getCheckDao();
		return  dao.getJohariUserAns(appId,username);
	}

	public List<Integer> getEligibleApplicationIdsForTermination(){
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		return adminAppDao.getEligibleApplicationIdsForTermination();
	}

	public List<ImprovementOptions> getImprovementOptions(){
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		return adminAppDao.getImpromentOptions();
	}
	public void addImprovementOptions(String name, String description, boolean isActive) throws Exception{
		AdminAppDAO adminAppDao=DaoFactory.getAdminJDBCDao();
		adminAppDao.addImpromentOptions(name, description,isActive);
	}
}