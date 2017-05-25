/**
 * 
 */
package com.ciber.quartz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ciber.quartz.dto.EmailReminderDto;
import com.ciber.template.Dbconnection;

/**
 * @author lmuriyal
 *
 */
public class EmailDaoImpl implements IEmailDao {

	@Override
	public List<EmailReminderDto> getElegibleEmployeeListForNotification() {

		StringBuilder reminderQuery = new StringBuilder();
		reminderQuery.append("SELECT DISTINCT EMP.EMPLOYEE_NAME AS EMPPLOYEENAME,EMP.EMPLOYEE_NUM AS EMPNUM, " +
				"EMP.EMAIL_ID AS EMPLOYEEEMAILID, APP.APP_ID AS APPLICATIONID,(SELECT TOP 1  EMP1.EMPLOYEE_NAME " +
				"FROM GIDC.T_EMPLOYEE EMP1 WHERE EMP1.EMPLOYEE_NUM=APP.EMPLOYEE_NUM) AS REFEMPNAME " +
				"FROM REFLECTION.APPLICATION APP, REFLECTION.ELIG_EMPLOYEE_LIST ELIG, GIDC.T_EMPLOYEE EMP " +
				"WHERE CONVERT(VARCHAR(10),APP.STOP_DATE,120)=  CONVERT(VARCHAR(10),DATEADD(DAY,1,CONVERT(DATETIME, GETDATE())),120)" +
				" AND APP.APP_ID = ELIG.APPID  AND ELIG.COMPLETED =0 AND ELIG.EMPID = EMP.EMPLOYEE_NUM " +
				"AND EMP.EMAIL_ID IS NOT NULL AND EMP.IS_DELETED =0 AND EMP.COUNTRY_ID =1 AND APP.COMPLETED_FLAG =0");

//		reminderQuery.append(
//				"select distinct emp.EMPLOYEE_NAME as empployeename,emp.EMPLOYEE_NUM as empNum, emp.EMAIL_ID as employeeEmailID, app.app_id as applicationID,(select top 1  emp1.EMPLOYEE_NAME from GIDC.T_EMPLOYEE emp1 where emp1.EMPLOYEE_NUM=app.employee_num) as refEmpName from REFLECTION.application app, REFLECTION.elig_employee_list elig, ");
//		reminderQuery.append(
//				" GIDC.T_EMPLOYEE emp where app.stop_date=DATEADD(day,1,Convert(date, getdate())) and app.app_id = elig.appId ");
//		reminderQuery.append(" and elig.completed =0 and elig.empId = emp.EMPLOYEE_NUM and emp.EMAIL_ID is not null and emp.IS_DELETED =0 and emp.COUNTRY_ID =1 and app.completed_flag =0 ");

		Connection con = Dbconnection.getSQLConnection();

		PreparedStatement statement = null;

		List<EmailReminderDto> emailReminderList = new ArrayList<EmailReminderDto>();

		try {
			statement = con.prepareStatement(reminderQuery.toString());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				EmailReminderDto aEmailReminderDto = new EmailReminderDto();

				aEmailReminderDto.setEmployeeName(rs.getString("empployeename"));
				aEmailReminderDto.setEmployeeEmailID(rs.getString("employeeEmailID"));
				aEmailReminderDto.setReflectionEmpName(rs.getString("refEmpName"));
				aEmailReminderDto.setAppID(rs.getInt("applicationID"));
				aEmailReminderDto.setEmployeeNum(rs.getString("empNum"));

				emailReminderList.add(aEmailReminderDto);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while updating.");
		}

		finally {
			try {
				if (statement != null)
					statement.close();

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return emailReminderList;

	}

}
