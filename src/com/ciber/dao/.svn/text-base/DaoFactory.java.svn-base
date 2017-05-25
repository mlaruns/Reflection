package com.ciber.dao;

import com.ciber.admin.dao.AddEmployeeDAO;
import com.ciber.admin.dao.AddEmployeeDAOimpl;
import com.ciber.admin.dao.UpdateManagerInfoDAO;
import com.ciber.admin.dao.UpdateManagerInfoDAOImpl;

public class DaoFactory
{
	public static LoginDAO getLoginDao()
	{
		return new LoginDAOImpl();
	}
	
	public static QuestionsDAO getQuesDao(){
		return (QuestionsDAO) new QuestionsDAOImpl();
	}
	
	public static CheckDAO getCheckDao(){
		return new CheckAnswerDAOImpl();
	}
	
	public static AdminAppDAO getAdminJDBCDao(){
		return new AdminAppDAOImpl();
	}
	
	public static LoginDAO getCurrentAppDao()
	{
		return new LoginDAOImpl();
	}
	

	
	
	/**
	 * to Add Employee List:for Criteria
	 */
	public static AddEmployeeDAO addEmployeeList(){
		return new AddEmployeeDAOimpl();
		
	}
	
	public static UpdateManagerInfoDAO getUpdateManagerInfoDAO()
	{
		return new UpdateManagerInfoDAOImpl();
	}

}
