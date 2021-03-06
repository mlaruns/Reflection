package com.ciber.dao;

import java.util.List;
import java.util.Map;

import com.ciber.beans.JohariWidowAdjectives;
import com.ciber.beans.Questions;

public interface QuestionsDAO {
	public  Map<String,Questions>   questionList(String appId,String userID,String role);
	public List<Questions> QuestionListReport(String appId);
	public List<Questions> QuestionListFeedBack(String appId);
	public Map<String,String> getAllQuestions() ;
	public List<JohariWidowAdjectives> getJohariWidowAdjectives();
	 
}
