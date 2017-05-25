package com.ciber.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.EmployeeList;
import com.ciber.template.Dbconnection;

public class AddEmployeeDAOimpl implements AddEmployeeDAO {

	@Override
	public boolean addEmployeeList(EmployeeList employeeList,String appID) {
		// TODO Auto-generated method stub
		String empId=employeeList.getEmpID();
		String Query1 = "Insert into reflection.Elig_Employee_List(appId,empId,completed,ans_count,mask_id,role) Values(?,?,?,?,?,?)";
		Connection connection = Dbconnection.getSQLConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(Query1);
			preparedStatement.setInt(1, Integer.valueOf(appID));
			preparedStatement.setString(2, employeeList.getEmpID());
			preparedStatement.setString(3, "0");
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5, "0");
			preparedStatement.setString(6, employeeList.getRole());
			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{

			try{
				if(preparedStatement != null) 
					preparedStatement.close();
				if(resultSet != null) 
					resultSet.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connection=null;
			}
		} 

		return true;
	}

	
	}
