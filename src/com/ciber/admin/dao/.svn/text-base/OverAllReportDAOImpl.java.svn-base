package com.ciber.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ciber.beans.ExcelBean;
import com.ciber.beans.ReportBean;
import com.ciber.beans.User;
import com.ciber.template.Dbconnection;

public class OverAllReportDAOImpl {

	private ResourceBundle resourceBundle = ResourceBundle.getBundle("com/ciber/properties/ApplicationResource");
	public static final String respondents = "true";
	public static final String notRespondents = "false";

	private String getApplicationStatus(String appId) {
		String query = "select completed_flag from  REFLECTION.application where app_id=?";
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		String status = null;
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, appId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				status = rs.getString("completed_flag");
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
		return status;
	}

	public String getEmployee(String appId) {

		String query = "select employee_num from reflection.application where app_id=?";
		Connection connect = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		try {
			statement = connect.prepareStatement(query);
			statement.setString(1, appId);
			ResultSet questionsRS = statement.executeQuery();
			while (questionsRS.next()) {
				return questionsRS.getString("employee_num");
			}
		} catch (Exception e) {

		}
		return null;
	}

	public ExcelBean getReports(String appId,String empLevel) {
		Connection connect = Dbconnection.getSQLConnection();
		String questionsQuery = getReport()
				+ " AND UA.SURVEYID=? GROUP BY QQ.QUESTION ,qq.questionPriority, UA.QUESTIONNO, qq.Competency,qq.Sub_Competency ,re.comments,re.improvementOption,re.Competency order by qq.Competency,qq.Sub_Competency desc";
		PreparedStatement statement = null;
		String questionPriority = null;
		String positiveGreen = resourceBundle.getString("report.question.positiveGreen");
		String negitiveGreen = resourceBundle.getString("report.question.negitiveGreen");
		ExcelBean bean = new ExcelBean();
		try {
			statement = connect.prepareStatement(questionsQuery);
			statement.setString(1, appId);
			ResultSet questionsRS = statement.executeQuery();
			List<ReportBean> beans = new ArrayList<ReportBean>();
			bean.setSurveyStatus(getApplicationStatus(appId));
			while (questionsRS.next()) {
				ReportBean rBean = new ReportBean();
				rBean.setQuestionno(questionsRS.getString("questionNo"));
				rBean.setCompetency(questionsRS.getString("Competency"));
				rBean.setSubCompetency(questionsRS.getString("Sub_Competency"));
				rBean.setQuestionName(questionsRS.getString("question"));
				rBean.setNever(questionsRS.getString("Never"));
				rBean.setSomeTimes(questionsRS.getString("Sometimes"));
				rBean.setOften(questionsRS.getString("Often"));
				rBean.setAlways(questionsRS.getString("Always"));
				rBean.setComments(questionsRS.getString("comments"));
				rBean.setImprovementOption(questionsRS.getString("improvementOption"));
				rBean.setChecked(questionsRS.getString("checked"));
				questionPriority = questionsRS.getString("questionPriority");
				if (bean.getSurveyStatus().equalsIgnoreCase("2")) {

				}
				if (questionPriority != null && !"".equals(questionPriority.trim())) {
					if (positiveGreen.equalsIgnoreCase(questionPriority)) {
						rBean.setQuestionPriority("ALWAYSGREEN");
					} else if (negitiveGreen.equalsIgnoreCase(questionPriority)) {
						rBean.setQuestionPriority("NEVERGREEN");
					}
				} else {
					rBean.setQuestionPriority("ALWAYSGREEN");
				}
				progressCalculation(rBean);
				beans.add(rBean);
			}
			int noOfRespondents = getRespondentCount(appId,empLevel,respondents);
			int noOfNotRespondents = getRespondentCount(appId,empLevel,notRespondents);
			int percNotRespondents = (noOfRespondents *100)/(noOfNotRespondents + noOfRespondents);
			bean.setNoOfRespondents(noOfRespondents);
			bean.setNoOfNotRespondents(percNotRespondents);
			bean.setAnsbean(beans);
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (connect != null)
					connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bean;
	}

	/**
	 * Generate Reports
	 * 
	 * @param empLevel
	 * @param empComp
	 * @return ExcelBean
	 */
	public ExcelBean getOverALLReports(String empLevel, String empComp,User userDetails) {
		Connection connect = Dbconnection.getSQLConnection();

		String questionsQuery = getStringReport(empLevel)
				+ " GROUP BY  QQ.QUESTION ,QQ.QUESTIONPRIORITY, UA.QUESTIONNO, " + "QQ.COMPETENCY,QQ.SUB_COMPETENCY";

		PreparedStatement statement = null;
		String questionPriority = null;
		String positiveGreen = resourceBundle.getString("report.question.positiveGreen");
		String negitiveGreen = resourceBundle.getString("report.question.negitiveGreen");

		ExcelBean bean = new ExcelBean();
		try {
			statement = connect.prepareStatement(questionsQuery);
			ResultSet questionsRS = statement.executeQuery();
			List<ReportBean> beans = new ArrayList<ReportBean>();
			while (questionsRS.next()) {
				questionPriority = null;
				ReportBean rBean = new ReportBean();
				rBean.setQuestionno(questionsRS.getString("questionNo"));
				rBean.setQuestionName(questionsRS.getString("question"));
				rBean.setCompetency(questionsRS.getString("Competency"));
				rBean.setSubCompetency(questionsRS.getString("Sub_Competency"));
				rBean.setNever(questionsRS.getString("Never"));
				rBean.setSomeTimes(questionsRS.getString("Sometimes"));
				rBean.setOften(questionsRS.getString("Often"));
				rBean.setAlways(questionsRS.getString("Always"));
				questionPriority = questionsRS.getString("questionPriority");
				if (questionPriority != null && !"".equals(questionPriority.trim())) {
					if (positiveGreen.equalsIgnoreCase(questionPriority)) {
						rBean.setQuestionPriority("ALWAYSGREEN");
					} else if (negitiveGreen.equalsIgnoreCase(questionPriority)) {
						rBean.setQuestionPriority("NEVERGREEN");
					}
				} else {
					rBean.setQuestionPriority("ALWAYSGREEN");
				}

				progressCalculation(rBean);

				beans.add(rBean);
			}
			bean.setAnsbean(beans);
			bean.setTotalReflections(getTotalReflections(empLevel));
			
			int noOfRespondents = getRespondentCount(null,empLevel,respondents);
			int noOfNotRespondents =  getRespondentCount(null,empLevel,notRespondents);
			int percNotRespondents = (noOfRespondents *100)/(noOfNotRespondents + noOfRespondents);
			bean.setNoOfRespondents(noOfRespondents);
			bean.setNoOfNotRespondents(percNotRespondents);
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (connect != null)
					connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bean;
	}

	public ArrayList<Integer> getQuestionsCountOfEachSection(ArrayList<String> questionsHeaders) {
		ArrayList<Integer> questionsCountOfEachSectionList = new ArrayList<Integer>();
		Connection connect = Dbconnection.getSQLConnection();
		PreparedStatement statement = null;
		String questionsCountOfEachSectionQuery = "select count(question_ID) from reflection.questionsquiz where secTYPE= ?";
		try {
			statement = connect.prepareStatement(questionsCountOfEachSectionQuery);
			for (String questionsHeader : questionsHeaders) {
				statement.setString(1, questionsHeader);
				ResultSet questionsCountSet = statement.executeQuery();
				while (questionsCountSet.next()) {
					String string = questionsCountSet.getString("count(question_ID)");
					Integer integer = new Integer(string);
					questionsCountOfEachSectionList.add(integer);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return questionsCountOfEachSectionList;
	}

	private void progressCalculation(ReportBean rBean) {
		int totalAns = 0;
		int never = Integer.parseInt(rBean.getNever());
		int someTimes = Integer.parseInt(rBean.getSomeTimes());
		int often = Integer.parseInt(rBean.getOften());
		int always = Integer.parseInt(rBean.getAlways());
		totalAns = never + someTimes + often + always;
		if (totalAns != 0) {
			rBean.setNeverPercentage(((never * 100) / totalAns) + "");
			rBean.setSomeTimesPercentage(((someTimes * 100) / totalAns) + "");
			rBean.setOftenPercentage(((often * 100) / totalAns) + "");
			rBean.setAlwaysPercentage(((always * 100) / totalAns) + "");
		}

	}

	/**
	 * Method to construct SQL for generating reports
	 * 
	 * @return SQL String
	 */
	private String getStringReport(String empLevel) {

		String strReport = "SELECT QQ.QUESTION , QQ.QUESTIONPRIORITY,QQ.COMPETENCY,QQ.SUB_COMPETENCY,UA.QUESTIONNO,"
				+ "SUM(CASE WHEN CORRECTANS='NEVER' THEN 1 " + "ELSE 0 END )AS NEVER,"
				+ "SUM(CASE WHEN CORRECTANS='OFTEN' THEN 1 " + "ELSE 0 END) AS OFTEN,"
				+ "SUM(CASE WHEN CORRECTANS='SOMETIMES' THEN 1 " + "ELSE 0 END) AS SOMETIMES,"
				+ "SUM(CASE WHEN CORRECTANS='ALWAYS' THEN 1 " + "ELSE 0 END) AS ALWAYS " + "FROM "
				+ "REFLECTION.USER_ANSWERS UA,REFLECTION.QUESTIONSQUIZ QQ,REFLECTION.APPLICATION AA,GIDC.T_EMPLOYEE TE "
				+ "WHERE  " + "UA.QUESTIONNO = QQ.QUESTION_ID " + "AND AA.APP_ID=UA.SURVEYID "
				+ "AND AA.COMPLETED_FLAG <> 0 " + "AND TE.COUNTRY_ID =1 " + "AND TE.IS_DELETED=0 "
				+ "AND AA.EMPLOYEE_NUM = TE.EMPLOYEE_NUM";
		if (empLevel != null && !empLevel.equals("")) {
			strReport = strReport + " AND TE.EMPLOYEELEVEL = '" + empLevel + "'";
		}
		return strReport;

	}

	private String getReport() {
		String query = "SELECT qq.question , qq.questionPriority,qq.Competency,qq.Sub_Competency,ua.questionno,re.comments,re.improvementOption,"
				+ " CASE WHEN re.Competency IS not null THEN 'yes' ELSE null END AS checked,"
				+ " SUM(CASE WHEN CORRECTANS='NEVER' THEN 1 ELSE 0 END )AS NEVER,"
				+ " SUM(CASE WHEN CORRECTANS='OFTEN' THEN 1 ELSE 0 END) AS OFTEN,"
				+ " SUM(CASE WHEN CORRECTANS='SOMETIMES' THEN 1 ELSE 0 END) AS SOMETIMES,"
				+ " SUM(CASE WHEN CORRECTANS='ALWAYS' THEN 1 ELSE 0 END) AS ALWAYS"
				+ " FROM REFLECTION.USER_ANSWERS UA join REFLECTION.QUESTIONSQUIZ QQ on (UA.QUESTIONNO = QQ.QUESTION_ID ) join REFLECTION.APPLICATION AA on (AA.APP_ID=UA.SURVEYID )"
				+ " left join REFLECTION.Review re on UA.QUESTIONNO=re.question_No and re.Survey_Id=UA.SURVEYID where AA.COMPLETED_FLAG <> 0";
		return query;
	}

	/**
	 * Method to fetch total number of reflections completed
	 * 
	 * @return int
	 */
	private int getTotalReflections(String empLevel) {
		int totalReflections = 0;
		Connection connect = Dbconnection.getSQLConnection();
		String getReflectionsSQL = "SELECT  COUNT(*) FROM GIDC.REFLECTION.APPLICATION AA, GIDC.GIDC.T_EMPLOYEE TE WHERE AA.COMPLETED_FLAG <>0"
				+ "AND AA.EMPLOYEE_NUM = TE.EMPLOYEE_NUM " + "AND TE.COUNTRY_ID =1 AND TE.IS_DELETED=0";
		if (empLevel != null && !empLevel.equals("")) {
			getReflectionsSQL = getReflectionsSQL + " AND TE.EMPLOYEELEVEL = '" + empLevel + "'";
		}
		PreparedStatement statement = null;
		try {
			statement = connect.prepareStatement(getReflectionsSQL);
			ResultSet questionsRS = statement.executeQuery();
			while (questionsRS.next()) {
				totalReflections = questionsRS.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalReflections;
	}

	/**
	 * Method to construct SQL for generating reports
	 * 
	 * @return ExcelBean
	 */
	public ExcelBean getCompetencyReport(String empLevel, String empComp,User userDetails) {

		ExcelBean beanCompetency = new ExcelBean();
		Connection connect = Dbconnection.getSQLConnection();
		String strReport = getCompetencySQL(empLevel, empComp);
		PreparedStatement statement = null;
		String questionPriority = null;
		String positiveGreen = resourceBundle.getString("report.question.positiveGreen");
		String negitiveGreen = resourceBundle.getString("report.question.negitiveGreen");

		try {
			statement = connect.prepareStatement(strReport);
			ResultSet questionsRS = statement.executeQuery();
			List<ReportBean> beans = new ArrayList<ReportBean>();
			while (questionsRS.next()) {
				questionPriority = null;
				ReportBean rBean = new ReportBean();
				rBean.setCompetency(questionsRS.getString("Competency"));
				rBean.setNever(questionsRS.getString("Never"));
				rBean.setSomeTimes(questionsRS.getString("Sometimes"));
				rBean.setOften(questionsRS.getString("Often"));
				rBean.setAlways(questionsRS.getString("Always"));
				questionPriority = questionsRS.getString("questionPriority");
				if (questionPriority != null && !"".equals(questionPriority.trim())) {
					if (positiveGreen.equalsIgnoreCase(questionPriority)) {
						rBean.setQuestionPriority("ALWAYSGREEN");
					} else if (negitiveGreen.equalsIgnoreCase(questionPriority)) {
						rBean.setQuestionPriority("NEVERGREEN");
					}
				} else {
					rBean.setQuestionPriority("ALWAYSGREEN");
				}

				ReportBean tempBean = null;
				if (beans.indexOf(rBean) != -1) {
					if (rBean.getQuestionPriority().equals("NEVERGREEN")) {
						tempBean = beans.get(beans.indexOf(rBean));
						rBean.setNever(Integer.parseInt(rBean.getNever().trim())
								+ Integer.parseInt(tempBean.getAlways().trim()) + "");
						rBean.setAlways(Integer.parseInt(rBean.getAlways().trim())
								+ Integer.parseInt(tempBean.getNever().trim()) + "");
						rBean.setSomeTimes(Integer.parseInt(rBean.getSomeTimes().trim())
								+ Integer.parseInt(tempBean.getOften().trim()) + "");
						rBean.setOften(Integer.parseInt(rBean.getOften().trim())
								+ Integer.parseInt(tempBean.getSomeTimes().trim()) + "");
						beans.remove(beans.indexOf(rBean));
					}
				}
				progressCalculation(rBean);

				beans.add(rBean);
			}
			beanCompetency.setAnsbean(beans);
			beanCompetency.setTotalReflections(getTotalReflections(empLevel));
			int noOfRespondents = getRespondentCount(null,empLevel,respondents);
			int noOfNotRespondents =  getRespondentCount(null,empLevel,notRespondents);
			int percNotRespondents = (noOfRespondents *100)/(noOfNotRespondents + noOfRespondents);
			beanCompetency.setNoOfRespondents(noOfRespondents);
			beanCompetency.setNoOfNotRespondents(percNotRespondents);
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (connect != null)
					connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanCompetency;
	}

	/**
	 * @param empLevel
	 * @param empComp
	 * @return
	 */
	private String getCompetencySQL(String empLevel, String empComp) {

		String strReport = "SELECT QQ.COMPETENCY,QQ.QUESTIONPRIORITY,"
				+ "SUM(CASE WHEN CORRECTANS='NEVER' THEN 1 ELSE 0 END )AS NEVER,"
				+ "SUM(CASE WHEN CORRECTANS='OFTEN' THEN 1 ELSE 0 END) AS OFTEN,"
				+ "SUM(CASE WHEN CORRECTANS='SOMETIMES' THEN 1 ELSE 0 END) AS SOMETIMES,"
				+ "SUM(CASE WHEN CORRECTANS='ALWAYS' THEN 1 ELSE 0 END) AS ALWAYS " + "FROM "
				+ "GIDC.REFLECTION.USER_ANSWERS UA,GIDC.REFLECTION.QUESTIONSQUIZ QQ,GIDC.REFLECTION.APPLICATION AA, GIDC.GIDC.T_EMPLOYEE TE "
				+ "WHERE  " + "UA.QUESTIONNO = QQ.QUESTION_ID " + "AND AA.APP_ID=UA.SURVEYID "
				+ "AND AA.COMPLETED_FLAG <> 0 " + "AND AA.EMPLOYEE_NUM = TE.EMPLOYEE_NUM " + "AND TE.COUNTRY_ID =1 "
				+ "AND TE.IS_DELETED=0 ";
		if (empLevel != null && !empLevel.equals("")) {
			strReport = strReport + " AND TE.EMPLOYEELEVEL = '" + empLevel + "'";
		}
		strReport = strReport + " GROUP BY QQ.QUESTIONPRIORITY,QQ.COMPETENCY";
		return strReport;
	}

	private int getRespondentCount(String appId, String empLevel, String resp){
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		String query = "SELECT COUNT(*) AS COUNT  FROM GIDC.REFLECTION.ELIG_EMPLOYEE_LIST E, GIDC.REFLECTION.APPLICATION A,GIDC.GIDC.T_EMPLOYEE T" +
				" WHERE E.APPID = A.APP_ID AND A.COMPLETED_FLAG <> '0' " +
				" AND T.COUNTRY_ID =1 AND T.IS_DELETED=0 " +
				"AND A.EMPLOYEE_NUM = T.EMPLOYEE_NUM";
		if(resp.equalsIgnoreCase(respondents)){
			query = query + " AND E.COMPLETED = '1'";
		}
		if(resp.equalsIgnoreCase(notRespondents)){
			query = query + " AND E.COMPLETED = '0'";
		}
		if(appId!=null){
			query = query + " AND E.APPID='"+appId+"'";
		}
		if(empLevel!=null){
			query = query + " AND T.EMPLOYEELEVEL ='"+empLevel+"'";
		}
		try{
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
		}catch(SQLException e ){
			e.getMessage();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
				if(con!=null)
					con.close();
			} catch (Exception e) {
				e.toString();
			}
		}
		return count;
	
	}
		
}
