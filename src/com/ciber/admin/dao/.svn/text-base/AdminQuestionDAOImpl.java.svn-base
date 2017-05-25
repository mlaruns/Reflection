package com.ciber.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ciber.admin.form.QuestionModel;
import com.ciber.template.Dbconnection;

public class AdminQuestionDAOImpl {

	QuestionModel obQuestionModel;

	public AdminQuestionDAOImpl() {
	}

	public int addQuestion(QuestionModel obQuestionModel) {
		int i = 0;
		int n = 0;
		Connection connect = Dbconnection.getSQLConnection();
		String max_app_id = null;
		String surveyId="select max(app_id)as app_id from REFLECTION.application";
		String addQues1 = "insert into REFLECTION.QUESTIONSQUIZ(question,questionPriority,updated_by,mandatory,Competency,Sub_Competency,Attribute_Type,questionOrder,Peer_1,Peer_2,HR,IT,Crossfunctional,Admin,Qmo,Finance,RECRUITMENT,RMG,REPORTEE,SUPERVISOR,description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst0 = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		PreparedStatement pst4 = null;
		String questID = "select max(question_id) AS questionCount  from REFLECTION.questionsquiz ";
		String addQues2 = "insert into REFLECTION.ANSWER_OPTIONS(question_id,options)"
				+ " values(?,?)";
		
		ResultSet resultSet1=null;
		java.sql.ResultSet resultSet=null;
		try {
			connect.setAutoCommit(false);
			pst4 = connect.prepareStatement(surveyId);
			resultSet1=pst4.executeQuery();
			while(resultSet1.next())
			{
				max_app_id=resultSet1.getString("app_id");
			}
			
			pst1 = connect.prepareStatement(addQues1);
			pst1.setString(1, obQuestionModel.getQuestion());
			pst1.setString(2, obQuestionModel.getPriority());
			//pst1.setString(3, obQuestionModel.getUserName());
			pst1.setString(3, obQuestionModel.getUserName());
			pst1.setString(4, obQuestionModel.getMandatory());
			pst1.setString(5, obQuestionModel.getCompetency());
			pst1.setString(6, obQuestionModel.getSubCompetency());
			pst1.setString(7, "multipleChoice");
			pst1.setInt(8, 0);
			pst1.setString(9, obQuestionModel.getPeer1());
			pst1.setString(10, obQuestionModel.getPeer2());
			pst1.setString(11, obQuestionModel.getHr());
			pst1.setString(12, obQuestionModel.getIt());
			pst1.setString(13, obQuestionModel.getCrossfunctional());
			pst1.setString(14, obQuestionModel.getAdmin());
			pst1.setString(15, obQuestionModel.getQmo());
			pst1.setString(16, obQuestionModel.getFinance());
			pst1.setString(17, obQuestionModel.getRecruitment());
			pst1.setString(18, obQuestionModel.getRmg());
			pst1.setString(19, obQuestionModel.getReportee());
			pst1.setString(20, obQuestionModel.getSupervisor());
			pst1.setString(21, obQuestionModel.getDescription());
			pst1.executeUpdate();
			pst3 = connect.prepareStatement(questID);
			resultSet = pst3.executeQuery();
			if (resultSet.next()) {
				n = resultSet.getInt("questionCount");
			}

			//options are fixed no need to update
				pst2 = connect.prepareStatement(addQues2);
				pst2.setInt(1, n);
				pst2.setString(2, obQuestionModel.getAns1());
				pst2.addBatch();
				
				pst2.setInt(1, n);
				pst2.setString(2, obQuestionModel.getAns2());
				pst2.addBatch();
				
				pst2.setInt(1, n);
				pst2.setString(2, obQuestionModel.getAns3());
				pst2.addBatch();
				
				pst2.setInt(1, n);
				pst2.setString(2, obQuestionModel.getAns4());
				pst2.addBatch();
				
				pst2.executeBatch();
			i = 1;

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connect.commit();
				if (pst0 != null) {
					pst0.close();
				}
				if (pst1 != null) {
					pst1.close();
				}
				if (pst2 != null) {
					pst2.close();
				}
				if (pst3 != null) {
					pst3.close();

				}if (pst4 != null) {
					pst4.close();
				}
				if(resultSet1!=null)
					resultSet1.close();
				if(resultSet!=null)
					resultSet.close();
				
				connect.close();
				connect = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public int updateQuestion(QuestionModel obQuestionModel) {
		int i = 0;
		int n = obQuestionModel.getQuesID();
		Connection connect = Dbconnection.getSQLConnection();
		String addQues1 = "UPDATE reflection.questionsquiz set question=?,updated_by=?,Competency=?,Sub_Competency=?,Peer_1=?,Peer_2=?,HR=?,IT=?,Crossfunctional=?,Admin=?,Qmo=?,Finance=?,RECRUITMENT=?,RMG=?,REPORTEE=?,SUPERVISOR=?, description=?,questionPriority=? where question_id=?";
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
			
		
		ResultSet resultSet1=null;
		java.sql.ResultSet resultSet=null;
		try {
			connect.setAutoCommit(false);
			pst1 = connect.prepareStatement(addQues1);
			pst1.setString(1, obQuestionModel.getQuestion());
			pst1.setString(2, obQuestionModel.getUserName());
			pst1.setString(3, obQuestionModel.getCompetency());
			pst1.setString(4, obQuestionModel.getSubCompetency());
			pst1.setString(5, obQuestionModel.getPeer1());
			pst1.setString(6, obQuestionModel.getPeer2());
			pst1.setString(7, obQuestionModel.getHr());
			pst1.setString(8, obQuestionModel.getIt());
			pst1.setString(9, obQuestionModel.getCrossfunctional());
			pst1.setString(10, obQuestionModel.getAdmin());
			pst1.setString(11, obQuestionModel.getQmo());
			pst1.setString(12, obQuestionModel.getFinance());
			pst1.setString(13, obQuestionModel.getRecruitment());
			pst1.setString(14, obQuestionModel.getRmg());
			pst1.setString(15, obQuestionModel.getReportee());
			pst1.setString(16, obQuestionModel.getSupervisor());
			pst1.setString(17, obQuestionModel.getDescription());
			pst1.setString(18, obQuestionModel.getPriority());
			pst1.setInt(19, obQuestionModel.getQuesID());
			pst1.executeUpdate();
			
			/*	pst2 = connect.prepareStatement(addQues2);
				
				pst2.setString(1, obQuestionModel.getAns1());
				pst2.setInt(2, n);
				pst2.addBatch();
				
				pst2.setInt(2, n);
				pst2.setString(1, obQuestionModel.getAns2());
				pst2.addBatch();
				
				pst2.setInt(2, n);
				pst2.setString(1, obQuestionModel.getAns3());
				pst2.addBatch();
				
				pst2.setInt(2, n);
				pst2.setString(1, obQuestionModel.getAns4());
				pst2.addBatch();
				
				pst2.executeBatch();*/
			i = 1;

		} catch (SQLException e) {
			try {
				connect.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connect.commit();
				
				if (pst1 != null) {
					pst1.close();
				}
				if (pst2 != null) {
					pst2.close();
				}
				
				if(resultSet1!=null)
					resultSet1.close();
				if(resultSet!=null)
					resultSet.close();
				
				connect.close();
				connect = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
}