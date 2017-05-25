package com.ciber.dao;

import java.util.ArrayList;
import java.util.List;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.ImprovementOptions;
import com.ciber.beans.Review;
import com.ciber.beans.SurveyBean;


public interface AdminAppDAO {
	public boolean stopApplication(String appId);
	public ArrayList<ApplicationModel> viewRecentApplication(String startDate,String endDate);
	public int addApplication(SurveyBean bean);
	public boolean updateEmployeeCount(int count,String appID);
	
	public ArrayList<ApplicationModel> viewFeedback(String empId);
	
	public int addReview(Review review);
	public boolean updateApplication(String surveyId);
	public List<Review> getReviewInfo(String surveyId);
	
	public List<Integer> getEligibleApplicationIdsForTermination();
	public List<ImprovementOptions> getImpromentOptions();
	public void addImpromentOptions(String name, String description, boolean isActive) throws Exception;
	
}
