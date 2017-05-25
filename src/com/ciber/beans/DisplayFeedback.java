package com.ciber.beans;

import java.util.ArrayList;

public class DisplayFeedback {
	private String Question;
	private ArrayList<String> answerList;
	private String questionNo;
	private String respondedCount;
	private String notRespondedCount;
	private ArrayList<AnswerFeedback> answerFeedbacks;
	private String answer;
	private String appName;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public ArrayList<AnswerFeedback> getAnswerFeedbacks() {
		return answerFeedbacks;
	}
	public void setAnswerFeedbacks(ArrayList<AnswerFeedback> answerFeedbacks) {
		this.answerFeedbacks = answerFeedbacks;
	}
	public String getRespondedCount() {
		return respondedCount;
	}
	public void setRespondedCount(String respondedCount) {
		this.respondedCount = respondedCount;
	}
	public String getNotRespondedCount() {
		return notRespondedCount;
	}
	public void setNotRespondedCount(String notRespondedCount) {
		this.notRespondedCount = notRespondedCount;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public ArrayList<String> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(ArrayList<String> answerList) {
		this.answerList = answerList;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppName() {
		return appName;
	}
	

}
