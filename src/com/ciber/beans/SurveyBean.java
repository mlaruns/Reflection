package com.ciber.beans;

public class SurveyBean {
	public SurveyBean(){
		
	}
	public SurveyBean(String appName, String startDate,String endDate, String appType,String maskId,String openToall,String employeeNum,boolean showCount){
		this.appName=appName;
		this.startDate=startDate;
		this.endDate=endDate;
		this.appType=appType;
		this.maskId=maskId;
		this.openToall=openToall;
		this.employeeNum=employeeNum;
		this.showCount=showCount;
	}
	private int appID;
	private String appName;
	private String startDate;
	private String endDate;
	private String appType;
	private String maskId;
	private String openToall;
	private String employeeNum;
	private boolean showCount;
	
	
	public boolean isShowCount() {
		return showCount;
	}
	public void setShowCount(boolean showCount) {
		this.showCount = showCount;
	}
	private String surveyCreated;
	
	
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	public String getSurveyCreated() {
		return surveyCreated;
	}
	public void setSurveyCreated(String surveyCreated) {
		this.surveyCreated = surveyCreated;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getMaskId() {
		return maskId;
	}
	public void setMaskId(String maskId) {
		this.maskId = maskId;
	}
	public String getOpenToall() {
		return openToall;
	}
	public void setOpenToall(String openToall) {
		this.openToall = openToall;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	
	
}
