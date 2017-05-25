package com.ciber.admin.form;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class ApplicationModel extends org.apache.struts.action.ActionForm
{
	
	private FormFile formFile;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FormFile getFormFile() {
		return formFile;
	}
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	private String appId;
	private String role;
	private String openToall;
	private boolean showCount;
	
	
	
	public boolean isShowCount() {
		return showCount;
	}
	public void setShowCount(boolean showCount) {
		this.showCount = showCount;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOpenToall() {
		return openToall;
	}
	public void setOpenToall(String openToall) {
		this.openToall = openToall;
	}
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the deletedFlag
	 */
	public int getDeletedFlag() {
		return deletedFlag;
	}
	/**
	 * @param deletedFlag the deletedFlag to set
	 */
	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	/**
	 * @return the completedFlag
	 */
	public String getCompletedFlag() {
		return completedFlag;
	}
	/**
	 * @param completedFlag the completedFlag to set
	 */
	public void setCompletedFlag(String completedFlag) {
		this.completedFlag = completedFlag;
	}
	/**
	 * @return the appType
	 */
	public String getAppType() {
		return appType;
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
	public String getMaskId() {
		return maskId;
	}
	public void setMaskId(String maskId) {
		this.maskId = maskId;
	}
	
	/**
	 * @param appType the appType to set
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}
	private String appName;
	private String startDate;
	private String endDate;
	private int deletedFlag;

	private String completedFlag;
	private String appType;
	private String respondedCount;
	private String notRespondedCount;
	private String maskId;
	private String employeeID;
	private String improvementOptionName;
	private String improvementOptionDescription;
	private boolean improvementActive;
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.improvementActive = false;
	}
	public boolean isImprovementActive() {
		return improvementActive;
	}
	public void setImprovementActive(boolean improvementActive) {
		this.improvementActive = improvementActive;
	}
	public String getImprovementOptionDescription() {
		return improvementOptionDescription;
	}
	public void setImprovementOptionDescription(
			String improvementOptionDescription) {
		this.improvementOptionDescription = improvementOptionDescription;
	}
	public String getImprovementOptionName() {
		return improvementOptionName;
	}
	public void setImprovementOptionName(String improvementOptionName) {
		this.improvementOptionName = improvementOptionName;
	}

}