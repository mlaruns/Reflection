/**
 * 
 */
package com.ciber.quartz.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ciber.quartz.dto.QuartzJobDTO;
import com.ciber.template.Dbconnection;

/**
 * @author lmuriyal
 *
 */
public class JobLogDaoImpl implements IJobLogDao {

	@Override
	public int logJobRequest(QuartzJobDTO jobDto) {
		String insertQuery = " INSERT INTO REFLECTION.T_QUARTZ_JOB (JOB_NAME,JOB_STATUS,START_DATE,END_DATE,ERROR_DETAILS,COMMENTS) VALUES (?,?,?,?,?,?)";

		String lastUpdateId = "select MAX(JOB_ID) as jobID from REFLECTION.T_QUARTZ_JOB";

		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		int count = 0;

		PreparedStatement idStatement = null;

		try {
			statement = con.prepareStatement(insertQuery);

			statement.setString(1, jobDto.getJobName());
			statement.setString(2, jobDto.getJobStatus());
			statement.setString(3, jobDto.getStartDate());
			statement.setString(4, jobDto.getEndDate());
			statement.setString(5, jobDto.getErrorDetails());
			statement.setString(6, jobDto.getComments());

			int rows = statement.executeUpdate();

			idStatement = con.prepareStatement(lastUpdateId);
			resultSet = idStatement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt("jobID");
				System.out.println("JobID::::" + count);

			}

			if (!(rows > 0)) {
				count = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	@Override
	public void updateJobStatus(QuartzJobDTO jobDto) {
		String updateQuery = "update REFLECTION.T_QUARTZ_JOB set JOB_STATUS=?,END_DATE=?,ERROR_DETAILS=?,COMMENTS=? where JOB_ID=?";

		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(updateQuery);
			statement.setString(1, jobDto.getJobStatus());
			statement.setString(2, jobDto.getEndDate());
			statement.setString(3, jobDto.getErrorDetails());
			statement.setString(4, jobDto.getComments());
			statement.setInt(5, jobDto.getJobID());
			statement.execute();
		} catch (Exception e) {
			System.out.println("Exception occured while updating.");
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
