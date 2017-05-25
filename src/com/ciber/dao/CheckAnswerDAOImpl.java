package com.ciber.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciber.beans.JohariWidowAdjectives;
import com.ciber.beans.Questions;
import com.ciber.template.Dbconnection;

public class CheckAnswerDAOImpl implements CheckDAO{
	
	
	
	public String checkAnswerCount(String UserName,Map<String,Questions> answers,String applicationId){
		String ansCount = null;
		
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet resultSet=null;
		//String ansQuesQuery = "insert into user_answers(questionNo,correctAns,username,surveyId) values(?,?,?,?)";
		String ansQuesQuery="select count(*)as ansCount from reflection.user_answers ua where correctAns in(select options from reflection.answer_options ao  where ao.question_id=ua.questionNo) and ua.username=? and ua.surveyId=?;";
		try {
			pst = con.prepareStatement(ansQuesQuery);
			//pst.setString(1, key);
			//pst.setString(2, value.getAnswer());
			pst.setString(1,UserName);
			pst.setInt(2, Integer.parseInt(applicationId));
			resultSet=pst.executeQuery();
			while (resultSet.next())
			{
				ansCount=resultSet.getString("ansCount");
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pst!=null)
					pst.close();
								
				if(resultSet!=null)
					resultSet.close();
				
				if(con!=null)
					con.close();
			}catch (Exception e) {
			}
		}
		return ansCount;
	}
	public boolean insertAnswers(String username,  Map<String,Questions> map,String applicationId){
 
		boolean result = false;
		for (Map.Entry<String, Questions> entry : map.entrySet()) {
			String key = entry.getKey();
			Questions value = entry.getValue();
			
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String ansQuesQuery = "insert into reflection.user_answers(questionNo,correctAns,username,surveyId) values(?,?,?,?)";
		try {
			if(value!=null && value.getAnswer()!=null && !value.getAnswer().isEmpty()){
			pst = con.prepareStatement(ansQuesQuery);
			pst.setString(1, key);
			if(value.getAnswer()=="")
			pst.setString(2, null);
			else
			pst.setString(2,value.getAnswer() );	
			pst.setString(3,username);
			pst.setInt(4, Integer.parseInt(applicationId));
			pst.execute();
			result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if(con!=null)
					con.close();
			} catch (Exception e) {
				e.toString();
			}
		}
	}
		return result;
	}
	@Override
	public boolean insertJohariAnswers(String username, String johariAns, String applicationId){
		 
		boolean result = false;
		
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String ansQuesQuery = "insert into reflection.user_answers(questionNo,correctAns,username,surveyId) values(?,?,?,?)";
		try {
			
			pst = con.prepareStatement(ansQuesQuery);
			pst.setString(1, "-1");			
			pst.setString(2,johariAns );	
			pst.setString(3,username);
			pst.setInt(4, Integer.parseInt(applicationId));
			pst.execute();
			result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if(con!=null)
					con.close();
			} catch (Exception e) {
				e.toString();
			}
		}
	
		return result;
	}
	
	public boolean updateApplicationStatus(String username,  Map<String,Questions> map,String applicationId,String ans_count){
		 
		boolean result = false;
		for (Map.Entry<String, Questions> entry : map.entrySet()) {
			String key = entry.getKey();
			Questions value = entry.getValue();
		Connection con = Dbconnection.getSQLConnection();
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pstInsert = null;
		String empId = null;
		ResultSet rs = null;
//		String QueryReturn="select empId from Registration where empName=?";
		String QueryUpdate="update reflection.elig_employee_list set completed=?,ans_count=? where empId=? and appId=?";
		String queryInsert="insert into reflection.elig_employee_list (appId,empid,completed,ans_count)  values (?,?,?,?)";
		//String ansQuesQuery = "insert into user_answers(questionNo,correctAns,username,surveyId) values(?,?,?,?)";
		try {
//			pst1=con.prepareStatement(QueryReturn);
//			pst1.setString(1, username);
//			ResultSet resultSet=pst1.executeQuery();		
//			if(resultSet.next())
//			{
//				empId=resultSet.getString("empId");
//			}		
			//Start::Update elig_employee_list
			pst2=con.prepareStatement(QueryUpdate);
			pst2.setString(1, "1");
			pst2.setInt(2,Integer.parseInt(ans_count));
			pst2.setString(3,username);
			pst2.setString(4, applicationId);
			int res= pst2.executeUpdate();
			if (res==0){
				pstInsert = con.prepareStatement(queryInsert);
				pstInsert.setString(1, applicationId);
				pstInsert.setString(2,username);
				pstInsert.setString(3, "1");
				pstInsert.setInt(4,Integer.parseInt(ans_count));
				pstInsert.executeUpdate();
			}
			//End:elig_employee_list
			
			
			
			
			/*pst = con.prepareStatement(ansQuesQuery);
			pst.setString(1, key);
			pst.setString(2, value.getAnswer());
			pst.setString(3,username);
			pst.setInt(4, Integer.parseInt(applicationId));
			pst.execute();*/
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (pst1 != null) {
					pst1.close();
				}
				if (pst2 != null) {
					pst2.close();
				}
				if(con!=null)
					con.close();
			} catch (Exception e) {
				e.toString();
			}
		}
	}
		return result;
	}
	
	
	
public int flagCheckUser(String applicationId,String empId,String role)
{
	
	Connection con = Dbconnection.getSQLConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;
	int count =0;
	String Query = "select completed from reflection.elig_employee_list where appId=? and empId=? and role=?";
	
	PreparedStatement pst1 = null;
	//String ansQuesQuery = "insert into user_answers(questionNo,correctAns,username,surveyId) values(?,?,?,?)";
	try{
		pst = con.prepareStatement(Query);
		pst.setString(1, applicationId);
		pst.setString(2, empId);
		pst.setString(3, role);
		rs=pst.executeQuery();
		while(rs.next())
		{
			count=Integer.parseInt(rs.getString("completed"));
		}	
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
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
public List<Questions> getQuestion(String appId,String username,String role) {
	
	Connection con = Dbconnection.getSQLConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	int count =0;
	String Query = "select questionsquiz.question as question ,questionsquiz.question_ID as question_ID,user_answers.correctAns as correctAns from reflection.questionsquiz inner join reflection.user_answers  on question_ID = questionNo"+
	" where user_answers.username=? and surveyId=?";
	
	List<Questions> questions= new ArrayList<Questions>();
	//String ansQuesQuery = "insert into user_answers(questionNo,correctAns,username,surveyId) values(?,?,?,?)";
	try{
		pst = con.prepareStatement(Query);
		pst.setString(1, username);
		pst.setString(2, appId);
		rs=pst.executeQuery();
		while(rs.next())
		{
			Questions question = new Questions();
			question.setQuestion(rs.getString("question"));
			//question.setSectype(rs.getString("secType"));
			question.setQuesID(rs.getInt("question_ID"));
			if(rs.getString("correctAns")!=null) 
			question.setAnswer(rs.getString("correctAns"));
			else question.setAnswer("Not Attempted");
			questions.add(question);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
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
	return questions;
	
}
@Override
public String getJohariUserAns(String appId,String username){
	Connection con = Dbconnection.getSQLConnection();
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	
	String ansQueryStr = "SELECT correctAns FROM reflection.user_answers WHERE surveyId = ?	AND username = ? and questionNo = -1 ";
	String johariSQLStr = "SELECT option_name FROM [REFLECTION].[JohariWidowAdjectives] ";
	String johAns="";
	try{
		pst = con.prepareStatement(ansQueryStr);
		pst.setString(1, appId);
		pst.setString(2, username);
		
		rs=pst.executeQuery();
		if(rs.next())
		{
			 String correctAns = rs.getString("correctAns");
			 
			 pst1 = con.prepareStatement(johariSQLStr+"where option_id IN ("+correctAns+")");
			 rs1 = pst1.executeQuery();
			 while(rs1.next()){
				 if("".equals(johAns)){
					 johAns = rs1.getString("option_name");
				 }else{
					 johAns += ", "+rs1.getString("option_name");
				 }
			 }
			
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (pst1 != null) {
				pst1.close();
			}
			if (rs1 != null) {
				rs1.close();
			}
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
	return johAns;
}
	
}