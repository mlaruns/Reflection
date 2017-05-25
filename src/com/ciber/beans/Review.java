package com.ciber.beans;

public class Review {
	public Review(){
		
	}
	public Review(String surveyId,String competency,String subCompetency,String comments,String percent,String questionNo){
	this.subCompetency=subCompetency;
	this.surveyId=surveyId;
	this.competency=competency;
	this.comments=comments;
	this.percent=percent;
	this.questionNo=questionNo;
	}
	
	public Review(String reviewId,String surveyId,String competency,String subCompetency,String comments,String percent,String questionNo){
	this.reviewId=reviewId;
	this.subCompetency=subCompetency;
	this.surveyId=surveyId;
	this.competency=competency;
	this.comments=comments;
	this.percent=percent;
	this.questionNo=questionNo;
	}
	
	private String reviewId;
	private String surveyId;
	private String competency;
	private String comments;
	private String subCompetency;
	private String percent;
	private String questionNo;
	private String  improvementSelectID;
	
	
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getSubCompetency() {
		return subCompetency;
	}
	public void setSubCompetency(String subCompetency) {
		this.subCompetency = subCompetency;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getCompetency() {
		return competency;
	}
	public void setCompetency(String competency) {
		this.competency = competency;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getImprovementSelectID() {
		return improvementSelectID;
	}
	public void setImprovementSelectID(String improvementSelectID) {
		this.improvementSelectID = improvementSelectID;
	}
	

}
