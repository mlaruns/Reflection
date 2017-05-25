package com.ciber.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.ciber.beans.AnsweOptions;
import com.ciber.beans.JohariWidowAdjectives;
import com.ciber.beans.Questions;
import com.ciber.template.Dbconnection;

/**
 * 
 * @author rramireddy
 *
 */
public class QuestionsDAOImpl implements QuestionsDAO {

	Connection con = Dbconnection.getSQLConnection();

	public Map<String,Questions> questionList(String appId,String userId,String roleName) {
		String questions = "select top 10 QUESTION_ID,QUESTION,DESCRIPTION from reflection.questionsquiz where ";
		String role="SELECT Role FROM reflection.elig_employee_list where appId=? and empId=?";
		
		String options = "select OPTIONS,questionType from reflection.ANSWER_OPTIONS where QUESTION_ID =?";
		Questions questionsBean = null;
		Map<String,Questions> questionMap = new HashMap<String,Questions>();
		Map<String,Questions> sortHashMap1 = new HashMap<String,Questions>();
		PreparedStatement statement2=null;
		PreparedStatement statement=null;
		//PreparedStatement statement3=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
			
			if(roleName.equalsIgnoreCase("PEER1")){
				questions=questions+" Peer_1 = 'YES'";
			}else if(roleName.equalsIgnoreCase("PEER2")){
				questions=questions+" Peer_2 = 'YES'";
			}else if(roleName.equalsIgnoreCase("HRBP")){
				questions=questions+"  HR = 'YES'";
			}else if(roleName.equalsIgnoreCase("IT")){
				questions=questions+"  IT = 'YES'";
			}else if(roleName.equalsIgnoreCase("CROSSFUNCTION")){
				questions=questions+"  Crossfunctional = 'YES'";
			}else if(roleName.equalsIgnoreCase("ADMIN")){
				questions=questions+"  Admin = 'YES'";
			}else if(roleName.equalsIgnoreCase("QMO")){
				questions=questions+"  Qmo = 'YES'";
			}else if(roleName.equalsIgnoreCase("FINANCE")){
				questions=questions+"  Finance = 'YES'";
			}else if(roleName.equalsIgnoreCase("RMG")){
				questions=questions+"  RMG = 'YES'";
			}else if(roleName.equalsIgnoreCase("REPORTEE")){
				questions=questions+"  REPORTEE = 'YES'";
			}else if(roleName.equalsIgnoreCase("SUPERVISOR")){
				questions=questions+"  SUPERVISOR = 'YES'";
			}else if(roleName.equalsIgnoreCase("RECRUITMENT")){
				questions=questions+"  RECRUITMENT = 'YES'";
			}
			
			questions=questions+" order by NEWID()";
			
			System.out.println(questions);
			statement = con.prepareStatement(questions);
			rs1 = statement.executeQuery();
				while (rs1.next()) {
					questionsBean = new Questions();
					questionsBean.setQuesID(rs1.getInt(("QUESTION_ID")));
					questionsBean.setQuestion(rs1.getString(("QUESTION")));
					questionsBean.setDescription(rs1.getString(("DESCRIPTION")));
					statement2 = con.prepareStatement(options);
					statement2.setInt(1, questionsBean.getQuesID());
					rs2 = statement2.executeQuery();
					Set<AnsweOptions> list = new LinkedHashSet<AnsweOptions>();
					while (rs2.next()) {
						AnsweOptions answerOption = new AnsweOptions();
						answerOption.setQuestionType(rs2.getString("questionType"));
						answerOption.setOptions(rs2.getString("OPTIONS"));
						list.add(answerOption);
					}			
					questionsBean.setOption(new ArrayList(list));					
					questionMap.put(questionsBean.getQuesID()+"",questionsBean);
				}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if(statement!=null)
					statement.close();
				
				if(statement2!=null)
					statement2.close();
				if(rs1!=null)
					rs1.close();
				if(rs2!=null)
					rs2.close();
				
				if (con != null)

					con.close();

			} catch (Exception e) {

			}
		}
		sortHashMap1 = sortHashMap(questionMap);
		return questionMap;
	}
	
	 private List<Questions> compare(List<Questions> someEmployees){
		 
		 //List<Questions> someEmployees;
	   Collections.sort( someEmployees, new Comparator<Questions>(){
	    public int compare( Questions e1, Questions e2 ) {
	    	Integer integer1 = e1.getQuesID();
	    	Integer integer2 = e2.getQuesID();
	      return integer1.compareTo(integer2);
	    }
	  });
	  return someEmployees;
	 }
	
	  
	  public HashMap<String, Questions> sortHashMap(Map<String, Questions> questionMap){
		    Map<String, Questions> tempMap = new HashMap<String, Questions>();
		    for (String wsState : questionMap.keySet()){
		        tempMap.put(wsState,questionMap.get(wsState));
		    }

		    List<String> mapKeys = new ArrayList<String>(tempMap.keySet());
		    List<Questions> mapValues = new ArrayList<Questions>(tempMap.values());
		    List<Questions> someEmployees = compare(mapValues);
		    HashMap<String, Questions> sortedMap = new LinkedHashMap<String, Questions>();
		    Object[] sortedArray = someEmployees.toArray();
		    int size = sortedArray.length;
		    for (int i=0; i<size; i++){
		        sortedMap.put(mapKeys.get(mapValues.indexOf(sortedArray[i])), 
		                      (Questions)sortedArray[i]);
		    }
		    return sortedMap;
		}
	  
	  public List<Questions> QuestionListReport(String appId)
	  {
		  Connection con = null;
		  PreparedStatement statement =null;
		  ResultSet resultSet=null;
		  String Query="select question_ID,question from reflection.questionsquiz where surveyId=?";
		  List<Questions> QuestionList=new ArrayList<Questions>();
		  
		  try {

				con=Dbconnection.getSQLConnection();
				statement = con.prepareStatement(Query);
				statement.setString(1, appId);
				resultSet=statement.executeQuery();
				while(resultSet.next())
				{
					Questions questions=new Questions();
					questions.setQuesID(Integer.parseInt(resultSet.getString("question_ID")));
					questions.setQuestion(resultSet.getString("question"));
					QuestionList.add(questions);
				 
				}
				
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
				if (con != null)
					con.close();
			}catch(SQLException exception){
				exception.printStackTrace();
			}
			
		}
		  return QuestionList;
	  }
	@Override
	public List<Questions> QuestionListFeedBack(String appId) {
		// TODO Auto-generated method stub
		Connection con = null;
		  PreparedStatement statement =null;
		  ResultSet resultSet=null;
		  String Query="select question_ID,question from reflection.questionsquiz where surveyId=? and Attribute_Type=?";
		  List<Questions> QuestionList=new ArrayList<Questions>();
		  
		  try {

				con=Dbconnection.getSQLConnection();
				statement = con.prepareStatement(Query);
				statement.setString(1, appId);
				statement.setString(2, "feedback");
				resultSet=statement.executeQuery();
				while(resultSet.next())
				{
					Questions questions=new Questions();
					questions.setQuesID(Integer.parseInt(resultSet.getString("question_ID")));
					questions.setQuestion(resultSet.getString("question"));
					QuestionList.add(questions);
				 
				}
				
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
				if (con != null)
					con.close();
			}catch(SQLException exception){
				exception.printStackTrace();
			}
			
		}
		  return QuestionList;
	}
	
	
	@Override
	public Map<String,String> getAllQuestions() {
		// TODO Auto-generated method stub
		Connection con = null;
		  PreparedStatement statement =null;
		  ResultSet resultSet=null;
		  String Query="select question_ID,question from  REFLECTION.questionsquiz";
		  Map<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		  try {

				con=Dbconnection.getSQLConnection();
				statement = con.prepareStatement(Query);
				resultSet=statement.executeQuery();
				while(resultSet.next())
				{
				
					String qno=resultSet.getString("question_ID");
					String questionName=resultSet.getString("question");
					map.put(questionName, qno);
				 
				}
				
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
				if (con != null)
					con.close();
			}catch(SQLException exception){
				exception.printStackTrace();
			}
			
		}
		  return map;
	}

	@Override
	public List<JohariWidowAdjectives> getJohariWidowAdjectives() {

		String sqlStr = "select option_id, option_name from [REFLECTION].[JohariWidowAdjectives]";
		
		List<JohariWidowAdjectives> johariWidowList = new ArrayList<JohariWidowAdjectives>();
		Connection con = null;
		PreparedStatement statement=null;
		ResultSet rs = null;
		try {
			con=Dbconnection.getSQLConnection();
			statement = con.prepareStatement(sqlStr);
			rs = statement.executeQuery();
				while (rs.next()) {
					JohariWidowAdjectives adjectives= new JohariWidowAdjectives();
					adjectives.setOptionId(rs.getInt("option_id"));
					adjectives.setOptionName(rs.getString("option_name"));
					johariWidowList.add(adjectives);
				}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if(rs != null)
					rs.close();				
				if(statement!=null)
					statement.close();				
				if (con != null)
					con.close();

			} catch (Exception e) {

			}
		}
		
		return johariWidowList;
	
	}
	

}
