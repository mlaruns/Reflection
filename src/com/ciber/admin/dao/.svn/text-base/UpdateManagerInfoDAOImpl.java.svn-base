package com.ciber.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ciber.beans.EmployeeDetails;
import com.ciber.beans.MgrPeerInfo;
import com.ciber.beans.User;
import com.ciber.template.Dbconnection;

public class UpdateManagerInfoDAOImpl implements UpdateManagerInfoDAO{

	@Override
	public void updatePeerInfo(List<MgrPeerInfo> employeesDetails) {
		Connection connect=Dbconnection.getSQLConnection();
		PreparedStatement stm=null;
		try{
			stm=connect.prepareStatement("update gidc.t_employee set  PEER1=?,PEER2=?,CROSSFUNCTION=? where EMPLOYEE_NUM=? and IS_DELETED=0 and COUNTRY_ID=1");
		for(MgrPeerInfo mgrPeerInfo:employeesDetails){
		
			stm.setString(1, mgrPeerInfo.getPeer1Email());
			stm.setString(2, mgrPeerInfo.getPeer2Email());
			stm.setString(3, mgrPeerInfo.getCrossFunctionalEmail());
			stm.setString(4, mgrPeerInfo.getManagerId());
			int i=stm.executeUpdate();
			connect.commit();
		}
		System.out.println("updated sucessfully...");
		}catch(Exception exp){
			exp.printStackTrace();
			
		}
		finally{
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}

	@Override
	public void updateManagerInfo(List<EmployeeDetails> employeesDetails) {
		Connection connect=Dbconnection.getSQLConnection();
		PreparedStatement stm=null;
		try{
			stm=connect.prepareStatement("update gidc.t_employee set HR=?,IT=?,QMO=?,ADMIN=?,RMG=?,FINANCE=?,RECRUITMENT=? where EMPLOYEE_NUM=? and IS_DELETED=0 and COUNTRY_ID=1");
		for(EmployeeDetails employeeDetails:employeesDetails){
			stm.setString(1, employeeDetails.getHrbpEmail());
			stm.setString(2, employeeDetails.getItEmail());
			stm.setString(3, employeeDetails.getQmoEmail());
			stm.setString(4, employeeDetails.getAdminEmail());
			stm.setString(5, employeeDetails.getRmgEmail());
			stm.setString(6, employeeDetails.getFinanceEmail());
			stm.setString(7, employeeDetails.getRequitmentEmail());
			stm.setString(8, employeeDetails.getEmpId());
			int i=stm.executeUpdate();
			connect.commit();
		}
		}catch(Exception exp){
			exp.printStackTrace();
			
		}
		finally{
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
		@Override
		public int updateManagerInfoUI(EmployeeDetails employeeDetails) {
			Connection connect=Dbconnection.getSQLConnection();
			PreparedStatement stm=null;
			int i=0;
			try{
				stm=connect.prepareStatement("update gidc.t_employee set HR=?,IT=?,QMO=?,ADMIN=?,RMG=?,FINANCE=?,RECRUITMENT=?,PEER1=?,PEER2=?,CROSSFUNCTION=?  where EMPLOYEE_NUM=? and IS_DELETED=0 and COUNTRY_ID=1");
			
				stm.setString(1, employeeDetails.getHrbpEmail());
				stm.setString(2, employeeDetails.getItEmail());
				stm.setString(3, employeeDetails.getQmoEmail());
				stm.setString(4, employeeDetails.getAdminEmail());
				stm.setString(5, employeeDetails.getRmgEmail());
				stm.setString(6, employeeDetails.getFinanceEmail());
				stm.setString(7, employeeDetails.getRequitmentEmail());
				stm.setString(8, employeeDetails.getPeer1Email());
				stm.setString(9, employeeDetails.getPeer2Email());
				stm.setString(10, employeeDetails.getCrossFunctionalEmail());
				stm.setString(11, employeeDetails.getEmpId());
				i=stm.executeUpdate();
				connect.commit();
			
			}catch(Exception exp){
				exp.printStackTrace();
				
			}
			finally{
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			return i;
		
	}
	
	
	
	
	public List<User> getManagerName(String empNo) {
		Connection connect=Dbconnection.getSQLConnection();
		List<User> users=new ArrayList<User>();
		PreparedStatement stm=null;
		try{
			stm=connect.prepareStatement("select EMPLOYEE_NAME,EMPLOYEE_NUM,  EMPLOYEELEVEL,EMAIL_ID from gidc.t_employee where EMPLOYEE_NAME like ? and COUNTRY_ID=1 and IS_DELETED=0");
			stm.setString(1, "%"+empNo+"%");
			
			ResultSet rs=stm.executeQuery();
			while(rs.next()){
				User  user =new User();
				user.setEname(rs.getString("EMPLOYEE_NAME"));
				user.setEmpId(rs.getString("EMPLOYEE_NUM"));
				user.setDesignation(rs.getString("EMPLOYEELEVEL"));
				user.setEmail(rs.getString("EMAIL_ID"));
				users.add(user);
			}
		}catch(Exception exp){
			exp.printStackTrace();
			
		}
		finally{
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return users;
	}
	
}
