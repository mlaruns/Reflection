	package com.ciber.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.EmployeeList;
import com.ciber.beans.User;
import com.ciber.beans.UserApplicationList;
import com.ciber.template.Dbconnection;

public class LoginDAOImpl implements LoginDAO {

	Connection con = Dbconnection.getSQLConnection();
	PreparedStatement statement = null;

	


	public ArrayList<ApplicationModel> currentApplications(User userDetails) {
		ArrayList<ApplicationModel> currentApp = new ArrayList<ApplicationModel>();
		ApplicationModel appModel = null;
		ResultSet rs = null;
		Connection connection = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String Query = "select (select count(*) from reflection.elig_employee_list where completed='0' and appId=?),(select count(*) from reflection.elig_employee_list where completed='1' and appId=?)";
		try {
			rs = applicationList(userDetails,"");
			while (rs.next()) {

				appModel = new ApplicationModel();
				appModel.setAppId(rs.getString(1));
				appModel.setAppName(rs.getString(2));
				appModel.setAppType(rs.getString(3));
				appModel.setShowCount(rs.getBoolean(4));
				statement = connection.prepareStatement(Query);
				statement.setString(1, rs.getString(1));
				statement.setString(2, rs.getString(1));
				
				System.out.println(appModel.getAppType());
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					appModel.setRespondedCount(resultSet.getString(2));
					appModel.setNotRespondedCount(resultSet.getString(1));
				}

				currentApp.add(appModel);
			}
		} catch (Exception e) {
			System.out.println("Exception ! " + e.getMessage());
			e.printStackTrace();
		} finally {

			try {
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();

				if (connection != null)
					connection.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return currentApp;
	}

	public ArrayList<UserApplicationList> currentApplicationsUsr(
			User userDetails, String UserName) {
		ArrayList<UserApplicationList> currentApplicationLists = applicationListAPP(
				userDetails, UserName);
		return currentApplicationLists;
	}

	public ArrayList<UserApplicationList> applicationListAPP(User userDetails,
			 String UserName) {

		Connection connection = Dbconnection.getSQLConnection();
		ArrayList<UserApplicationList> currentApplicationLists = new ArrayList<UserApplicationList>();
		UserApplicationList appList = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String currentAppQuery = "SELECT app_id,app_name,app_type FROM reflection.application where completed_flag=0 and questUploaded=0";
		if (userDetails.getRole() != null) {
			if (UserName != null) {
				currentAppQuery = "SELECT app_id,app_name,app_type,role FROM reflection.application app join  reflection.Elig_Employee_List e on app.app_id=e.appId  WHERE e.empId=? and completed_flag=0 and questUploaded=0";
			}
		}

		try {
			pst = connection.prepareStatement(currentAppQuery);
			if (userDetails.getRole() != null) {
				if (UserName != null) {
					pst.setString(1, userDetails.getEmployeeId());
				}
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				appList = new UserApplicationList();
				appList.setAppId(rs.getString(1));
				appList.setUserappName(rs.getString(2));
				appList.setUserappType(rs.getString(3));
				if (UserName != null) {
					appList.setRole(rs.getString(4));
				}
				System.out.println(appList.getRole());
				currentApplicationLists.add(appList);
			}
		} catch (Exception e) {
			System.out.println("Exception ! " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				// NOT SUPPOSE TO CLOSE RESULTSET ***
				if (connection != null)
					connection.close();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		return currentApplicationLists;

	}

	public ResultSet applicationList(User userDetails, String UserName) {

		Connection connection = Dbconnection.getSQLConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String currentAppQuery = "SELECT app_id,app_name,app_type,show_count FROM reflection.application where completed_flag=0 and questUploaded=0";
		if (userDetails.getRole() != null) {
			if (userDetails.getRole().equalsIgnoreCase("u")) {
				currentAppQuery += " and employee_num=? ";
			}
		}
		try {
			pst = connection.prepareStatement(currentAppQuery);
			if (userDetails.getRole() != null) {
				if (userDetails.getRole().equalsIgnoreCase("u")) {
					pst.setString(1, userDetails.getEmployeeId());
				}
			}
			rs = pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
			} catch (Exception exception) {
				exception.printStackTrace();
			}

		}
		return rs;
	}

	public User getUserDetails(User user) {
		String employee = "select e.EMPLOYEE_NUM,e.EMPLOYEE_NAME,e.PROJECT_MANAGER,e.SUPERVISOR_NAME,e.SUPERVISOR_ID,"
				+ " case when mgr.SUPERVISOR_ID is not null then 1 else 0 end 'IsManager'"
				+ " from gidc.t_employee e"
				+ " left outer join "
				+ " (select SUPERVISOR_ID, COUNT(*) Rep_Cnt from gidc.t_employee"
				+ " where IS_DELETED=0 and COUNTRY_ID=1"
				+ " group by SUPERVISOR_ID"
				+ " having COUNT(*)>0) mgr"
				+ " on e.EMPLOYEE_NUM = mgr.SUPERVISOR_ID"
				+ " where IS_DELETED=0 and COUNTRY_ID=1 and e.EMAIL_ID=?";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		if (con != null)
			try {
				statement = con.prepareStatement(employee);
				statement.setString(1, user.getEmail());
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					user.setEmployeeId(rs.getString("EMPLOYEE_NUM"));
					user.setEname(rs.getString("EMPLOYEE_NAME"));
					user.setSupervisorId(rs.getString("SUPERVISOR_ID"));
					user.setProjectManagerName(rs.getString("PROJECT_MANAGER"));
					user.setSupervisorName(rs.getString("SUPERVISOR_NAME"));
					user.setIsReporties(rs.getBoolean("IsManager"));

					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
					if (statement != null) {
						statement.close();
					}
				} catch (Exception e) {

				}
			}
		return null;
	}

	public List<User> getReportiesDetails(String supervisorID) {
		List<User> reporties = new ArrayList<User>();
		String employee = "select e.EMPLOYEE_NUM,e.EMPLOYEE_NAME,e.PROJECT_MANAGER,e.SUPERVISOR_NAME,e.SUPERVISOR_ID,"
				+ " case when mgr.SUPERVISOR_ID is not null then 1 else 0 end 'IsManager'"
				+ " from gidc.t_employee e"
				+ " left outer join "
				+ " (select SUPERVISOR_ID, COUNT(*) Rep_Cnt from gidc.t_employee"
				+ " where IS_DELETED=0 and COUNTRY_ID=1"
				+ " group by SUPERVISOR_ID"
				+ " having COUNT(*)>0) mgr"
				+ " on e.EMPLOYEE_NUM = mgr.SUPERVISOR_ID"
				+ " where IS_DELETED=0 and COUNTRY_ID=1 and e.SUPERVISOR_ID=?";
		Connection con = Dbconnection.getSQLConnection();
		// Connection mysqlConnection=Dbconnection.getConnection();
		PreparedStatement statement = null;
		PreparedStatement employeeStatement = null;
		if (con != null)
			try {
				statement = con.prepareStatement(employee);
				statement.setString(1, supervisorID);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					User user = new User();
					user.setEmployeeId(rs.getString("EMPLOYEE_NUM"));
					user.setEname(rs.getString("EMPLOYEE_NAME"));
					user.setSupervisorId(rs.getString("SUPERVISOR_ID"));
					user.setProjectManagerName(rs.getString("PROJECT_MANAGER"));
					user.setSupervisorName(rs.getString("SUPERVISOR_NAME"));
					user.setIsReporties(rs.getBoolean("IsManager"));
					user.setIsSurveyCreated(isHaveFeedBack(user.getEmployeeId()));
					reporties.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
					if (con != null)
						con.close();

				} catch (Exception e) {

				}
			}
		return reporties;

	}

	
	
	public List<EmployeeList> getUsers(String employeeID) {
		List<EmployeeList> reporties = new ArrayList<EmployeeList>();
		String employee = "select manager.EMPLOYEE_NUM,manager.EMPLOYEE_NAME,manager.EMAIL_ID,"
				+ " CASE WHEN emp.PEER1=manager.EMAIL_ID THEN 'PEER1'"
				+ " WHEN emp.PEER2=manager.EMAIL_ID	THEN 'PEER2'"
				+ " WHEN emp.CROSSFUNCTION=manager.EMAIL_ID	THEN 'CROSSFUNCTION'"
				+ " WHEN emp.HR=manager.EMAIL_ID THEN 'HRBP'"
				+ " WHEN emp.IT=manager.EMAIL_ID THEN 'IT'"
				+ " WHEN emp.QMO=manager.EMAIL_ID THEN 'QMO'"
				+ " WHEN emp.ADMIN=manager.EMAIL_ID	THEN 'ADMIN'"
				+ " WHEN emp.RMG=manager.EMAIL_ID THEN 'RMG'"
				+ " WHEN emp.FINANCE=manager.EMAIL_ID THEN 'FINANCE'"
				+ " WHEN emp.RECRUITMENT=manager.EMAIL_ID THEN 'RECRUITMENT'"
				+ " WHEN emp.EMPLOYEE_NUM=manager.SUPERVISOR_ID THEN 'REPORTEE'"
				+ " WHEN emp.SUPERVISOR_ID=manager.EMPLOYEE_NUM THEN 'SUPERVISOR'"
				+ " END AS EmployeeRole"
				+ " FROM gidc.t_employee emp JOIN gidc.t_employee manager ON (emp.PEER1=manager.EMAIL_ID)"
				+ " OR (emp.PEER2=manager.EMAIL_ID) OR (emp.CROSSFUNCTION=manager.EMAIL_ID) OR (emp.HR=manager.EMAIL_ID)"
				+ " OR (emp.IT=manager.EMAIL_ID) OR (emp.QMO=manager.EMAIL_ID) OR (emp.ADMIN=manager.EMAIL_ID)"
				+ "OR (emp.RMG=manager.EMAIL_ID) OR (emp.FINANCE=manager.EMAIL_ID) OR (emp.RECRUITMENT=manager.EMAIL_ID)"
				+" OR (emp.EMPLOYEE_NUM=manager.SUPERVISOR_ID) or(emp.SUPERVISOR_ID=manager.EMPLOYEE_NUM)"
				+ "WHERE emp.EMPLOYEE_NUM=? and emp.IS_DELETED=0 and manager.IS_DELETED=0 and manager.COUNTRY_ID=1 and emp.COUNTRY_ID=1";
		Connection con = Dbconnection.getSQLConnection();
		// Connection mysqlConnection=Dbconnection.getConnection();
		PreparedStatement statement = null;
		if (con != null)
			try {
				statement = con.prepareStatement(employee);
				statement.setString(1, employeeID);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					EmployeeList user = new EmployeeList();
					user.setEmpID(rs.getString("EMPLOYEE_NUM"));
					user.setEmpName(rs.getString("EMPLOYEE_NAME"));
					user.setEmail(rs.getString("EMAIL_ID"));
					user.setRole(rs.getString("EmployeeRole"));
					reporties.add(user);
				}
				return reporties;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
					if (con != null)
						con.close();

				} catch (Exception e) {

				}
			}
		return null;

	}

	private boolean isHaveFeedBack(String employeeId) {
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		try {
			statement = con
					.prepareStatement("SELECT count(*) FROM reflection.application where completed_flag <> 0 and employee_num=?");
			statement.setString(1, employeeId);
			ResultSet employeecountRS = statement.executeQuery();
			if (employeecountRS.next()) {
				if (employeecountRS.getInt(1) >= 1) {
					return true;
				}
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (con != null)
					con.close();

			} catch (Exception e) {

			}
		}

		return false;
	}

}