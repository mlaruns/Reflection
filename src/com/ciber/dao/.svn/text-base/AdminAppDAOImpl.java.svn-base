package com.ciber.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.ImprovementOptions;
import com.ciber.beans.Review;
import com.ciber.beans.SurveyBean;
import com.ciber.template.Dbconnection;

public class AdminAppDAOImpl implements AdminAppDAO {
	@Override
	public boolean stopApplication(String appID) {
		String query = "update reflection.application set completed_flag=1 where app_id=? and completed_flag = 0 ";
		String updateFlag = "update reflection.application set completed_flag=1 where stop_date<GETDATE() and completed_flag = 0 ";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		boolean result = true;
		try {

			if (appID.equalsIgnoreCase("stop")) {
				statement = con.prepareStatement(updateFlag);
				statement.execute();

			} else {
				statement = con.prepareStatement(query);
				statement.setString(1, appID);
				int rows = statement.executeUpdate();
				if (!(rows > 0))
					result = false;
			}
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
		return result;
	}

	@Override
	public ArrayList<ApplicationModel> viewRecentApplication(String startDate, String endDate) {
		String emptyInputQuery = "select app_id,app_name,start_date,stop_date,completed_flag,app_type from reflection.application";
		String query = "select app_id,app_name,start_date,stop_date,completed_flag,app_type,employee_num from reflection.application where start_date >= ? and stop_date <=? and questUploaded=? and completed_flag <> ?";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		/*
		 * SimpleDateFormat simpleDate=new SimpleDateFormat("dd-MM-yyyy");
		 * SimpleDateFormat simpleDateFinal=new SimpleDateFormat("yyyy-MM-dd");
		 * try { startDate=simpleDateFinal.format(simpleDate.parse(startDate));
		 * endDate=simpleDateFinal.format(simpleDate.parse(endDate)); } catch
		 * (ParseException e1) { e1.printStackTrace(); }
		 * System.out.println(startDate+"  ::::::  "+endDate);
		 */
		ArrayList<ApplicationModel> recentApp = null;
		try {
			// if(startDate.equalsIgnoreCase(""))
			statement = con.prepareStatement(query);
			statement.setString(1, startDate);
			statement.setString(2, endDate);
			statement.setInt(3, 0);
			statement.setInt(4, 0);
			rs = statement.executeQuery();
			recentApp = new ArrayList<ApplicationModel>();
			ApplicationModel appModel = null;
			while (rs.next()) {
				appModel = new ApplicationModel();
				appModel.setAppId(rs.getString(1));
				appModel.setAppName(rs.getString(2));
				appModel.setStartDate(rs.getString(3).substring(0, 10));
				appModel.setEndDate(rs.getString(4).substring(0, 10));
				if (rs.getInt(5) == 1)
					appModel.setCompletedFlag("Completed");
				if (rs.getInt(5) == 2)
					appModel.setCompletedFlag("Reviewed");
				appModel.setAppType(rs.getString(6));
				appModel.setEmployeeID(rs.getString(7));
				recentApp.add(appModel);
			}
		} catch (Exception e) {
			System.out.println("Exception occured while updating." + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (rs != null)
					rs.close();

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return recentApp;
	}

	@Override
	public int addApplication(SurveyBean bean) {
		String query = "INSERT INTO reflection.application(app_name, start_date, stop_date,app_type,mask_id,openToall,employee_num,show_count) VALUES (?,?,?,?,?,?,?,?)";
		// String lastUpdateId="select LAST_INSERT_ID() as appId";
		// String lastUpdateId="SELECT SCOPE_IDENTITY() as appId";
		String lastUpdateId = "select MAX(app_id) as appId from REFLECTION.application";
		String appname = "select count(employee_num) as count from reflection.application where employee_num=? and completed_flag=0 ";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		int count = 0;
		boolean result = true;
		ResultSet resultSet = null;
		ResultSet rs = null;
		try {
			int exits = 0;
			statement2 = con.prepareStatement(appname);
			statement2.setString(1, bean.getEmployeeNum());
			rs = statement2.executeQuery();
			while (rs.next()) {
				exits = rs.getInt("count");
			}
			if (exits != 1) {
				statement = con.prepareStatement(query);
				statement.setString(1, bean.getAppName());
				statement.setString(2, bean.getStartDate());
				statement.setString(3, bean.getEndDate());
				statement.setString(4, bean.getAppType());
				statement.setString(5, bean.getMaskId());
				statement.setString(6, "0");
				statement.setString(7, bean.getEmployeeNum());
				statement.setBoolean(8, bean.isShowCount());
				int rows = statement.executeUpdate();

				statement1 = con.prepareStatement(lastUpdateId);
				resultSet = statement1.executeQuery();
				while (resultSet.next()) {
					count = resultSet.getInt("appId");
					System.out.println("AppId::::" + count);
					bean.setAppID(count);
				}
				if (!(rows > 0)) {
					// result= false;
					count = 0;
				}
			} else {
				bean.setSurveyCreated("Survey Not created");
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean.setSurveyCreated("Survey Not created");
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

	public boolean updateEmployeeCount(int count, String appId) {
		int app_Id = 0;
		String query = "update reflection.application set eligible_employee_count =? where app_id=?";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;

		try {
			statement = con.prepareStatement(query);
			statement.setString(1, Integer.toString(count));
			statement.setInt(2, Integer.valueOf(appId));
			statement.execute();
		} catch (Exception e) {
			System.out.println("Exception occured while updating.");
			e.printStackTrace();
		} finally {
			try {
				if (statement1 != null)
					statement1.close();
				if (statement != null)
					statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;

	}

	@Override
	public ArrayList<ApplicationModel> viewFeedback(String empId) {
		String query = "select app_id,app_name,start_date,stop_date,completed_flag,app_type,employee_num from reflection.application where employee_num=? and completed_flag <> ? order by  app_id desc";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;

		ArrayList<ApplicationModel> recentApp = null;
		try {
			// if(startDate.equalsIgnoreCase(""))
			statement = con.prepareStatement(query);
			statement.setString(1, empId);
			statement.setInt(2, 0);
			rs = statement.executeQuery();
			recentApp = new ArrayList<ApplicationModel>();
			ApplicationModel appModel = null;
			while (rs.next()) {
				appModel = new ApplicationModel();
				appModel.setAppId(rs.getString(1));
				appModel.setAppName(rs.getString(2));
				appModel.setStartDate(rs.getString(3).substring(0, 10));
				appModel.setEndDate(rs.getString(4).substring(0, 10));
				if (rs.getInt(5) == 1)
					appModel.setCompletedFlag("Completed");
				if (rs.getInt(5) == 2)
					appModel.setCompletedFlag("Reviewed");
				appModel.setAppType(rs.getString(6));
				appModel.setEmployeeID(rs.getString(7));
				recentApp.add(appModel);
			}
		} catch (Exception e) {
			System.out.println("Exception occured while updating.");
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (rs != null)
					rs.close();

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return recentApp;
	}

	@Override
	public int addReview(Review review) {
		String query = "INSERT INTO REFLECTION.review(Competency, Sub_Competency, percentage,comments,Survey_Id,question_No, improvementOption,CreationDate) VALUES (?,?,?,?,?,?,?,?)";
		int rows = 0;
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Calendar calender = Calendar.getInstance();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(calender.getTimeInMillis());
		try {

			statement = con.prepareStatement(query);
			statement.setString(1, review.getCompetency());
			statement.setString(2, review.getSubCompetency());
			statement.setString(3, review.getPercent());
			statement.setString(4, review.getComments());
			statement.setString(5, review.getSurveyId());
			statement.setString(6, review.getQuestionNo());
			statement.setString(7, review.getImprovementSelectID());
			statement.setTimestamp(8, timestamp);
			rows = statement.executeUpdate();
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
		return rows;
	}

	@Override
	public List<Review> getReviewInfo(String surveyId) {
		String query = "SELECT Competency,Sub_Competency,comments,percentage,question_No from  reflection.review where Survey_Id=? order by Competency desc";
		int rows = 0;
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		List<Review> reviews = new ArrayList<Review>();
		try {

			statement = con.prepareStatement(query);
			statement.setString(1, surveyId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setCompetency(rs.getString("Competency"));
				review.setSubCompetency(rs.getString("Sub_Competency"));
				review.setComments(rs.getString("comments"));
				review.setPercent(rs.getString("percentage"));
				review.setQuestionNo(rs.getString("question_No"));
				review.setSurveyId(surveyId);
				reviews.add(review);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while updating.");
		} finally {
			try {
				if (statement != null)
					statement.close();

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reviews;
	}

	@Override
	public boolean updateApplication(String appID) {
		String query = "update reflection.application set completed_flag=2 where app_id=?";

		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		boolean result = true;
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, appID);
			int rows = statement.executeUpdate();
			if (!(rows > 0)) {
				result = false;
			}
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
		return result;
	}

	@Override
	public List<Integer> getEligibleApplicationIdsForTermination() {

		StringBuilder appTerminationQuery = new StringBuilder();
		appTerminationQuery.append(" SELECT APP.APP_ID AS APPLICATIONID FROM REFLECTION.APPLICATION APP " +
				"WHERE APP.COMPLETED_FLAG =0 AND CONVERT(VARCHAR(10),APP.STOP_DATE,120)=  CONVERT(VARCHAR(10)," +
				"DATEADD(DAY,0,CONVERT(DATETIME, GETDATE())),120)");
//		appTerminationQuery.append(
//				"select app.app_id as applicationID from REFLECTION.application app where app.completed_flag =0 and app.stop_date=Convert(date, getdate()) ");

		Connection con = Dbconnection.getSQLConnection();

		PreparedStatement statement = null;

		List<Integer> Ids = new ArrayList<Integer>();

		try {
			statement = con.prepareStatement(appTerminationQuery.toString());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				Ids.add(rs.getInt("applicationID"));

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

		return Ids;

	}
	
	public List<ImprovementOptions> getImpromentOptions() {
		String query = "SELECT option_id, option_name FROM REFLECTION.ImprovementOptions where isActive=1";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		List<ImprovementOptions> improvementList = new ArrayList<ImprovementOptions>();
		try {

			statement = con.prepareStatement(query);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ImprovementOptions improvementOptions = new ImprovementOptions();
				improvementOptions.setOptionID(rs.getInt("option_id"));
				improvementOptions.setOptionName(rs.getString("option_name"));
				improvementList.add(improvementOptions);

			}
			
			System.out.println(improvementList.size());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while retriving REFLECTION.ImprovementOptions.");
		} finally {
			try {
				if (statement != null)
					statement.close();

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return improvementList;
	}

	@Override
	public void addImpromentOptions(String name, String description,boolean isActive) throws Exception{

		String query = "INSERT INTO [REFLECTION].[ImprovementOptions](option_name, description, isActive) VALUES (?,?,?)";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		try {

			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setBoolean(3, isActive);
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception occured whileImprovementOptions insert");
			throw e;			
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