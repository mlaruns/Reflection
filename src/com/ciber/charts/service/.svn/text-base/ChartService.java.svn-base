package com.ciber.charts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.ciber.admin.dao.OverAllReportDAOImpl;
import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.ExcelBean;
import com.ciber.beans.ReportBean;
import com.ciber.beans.Review;
import com.ciber.charts.bean.DataBean;
import com.ciber.charts.bean.SeriesBean;
import com.ciber.dao.DaoFactory;

public class ChartService {

    public DataBean getLineChartData1(ApplicationModel survey1,ApplicationModel survey2) {
    	ExcelBean bean1=null;
    	List<Review> reviews1=null;
    	String reviewed="";
    	String survey1Name=null;
    	String survey2Name=null;
    	if("Reviewed".equals(survey1.getCompletedFlag())){
    		reviews1=DaoFactory.getAdminJDBCDao().getReviewInfo(survey1.getAppId());
    		survey1Name=survey1.getAppName();
    		reviewed="first";
    	}
    	if("Reviewed".equals(survey2.getCompletedFlag())){
    		reviews1=DaoFactory.getAdminJDBCDao().getReviewInfo(survey2.getAppId());
    		survey1Name=survey2.getAppName();
    		reviewed="second";
    	}
    
    	if(reviewed=="second"){
    		OverAllReportDAOImpl overAllReportDao = new OverAllReportDAOImpl();
        		bean1 = overAllReportDao.getReports(survey1.getAppId(),null);
        		survey2Name=survey1.getAppName();
    	}else{
    		OverAllReportDAOImpl overAllReportDao = new OverAllReportDAOImpl();
        		bean1 = overAllReportDao.getReports(survey2.getAppId(),null);
        		survey2Name=survey2.getAppName();
    	}
    	 Double[] surv1Percent = new Double[reviews1.size()];
    	 Double[] surv2Percent = new Double[reviews1.size()];
    	 String[] softskills = new String[reviews1.size()];
    	 int i=0;
    	 HashSet<String> comptencySet=new HashSet<String>();
    	for(Review review:reviews1){
    	for(ReportBean bean:bean1.getAnsbean()){
    		if((review.getCompetency().equalsIgnoreCase(bean.getCompetency())) &&
    			(review.getSubCompetency().equalsIgnoreCase(bean.getSubCompetency()))){
    			String comptency=review.getCompetency()+" - "+review.getSubCompetency();
    			if(!comptencySet.contains(comptency)){
    			if(reviews1.size()>i){
    				comptencySet.add(comptency);
    			String firstSurvey=review.getPercent();
    			surv1Percent[i]=Double.valueOf(firstSurvey);
    			softskills[i]=review.getCompetency()+" - "+review.getSubCompetency();
    			String secondSurvey=bean.getAlwaysPercentage();
    			surv2Percent[i]=Double.valueOf(secondSurvey);
    				i++;
    			}
    			}
    		
    		}
    	}
    	}
    	if(i<3){
    		 return new DataBean("Comptencies you have selected in the "+survey1Name+" not found in the "+survey2Name);
    	}
   
    	List<SeriesBean> list = new ArrayList<SeriesBean>();
    
        list.add(new SeriesBean(survey1Name, "#3366cc", surv1Percent));
        list.add(new SeriesBean(survey2Name, "#8BBC21", surv2Percent));

        return new DataBean("chart1-container", "Reviews", "Percentage (%)", "Soft Skills", Arrays.asList(softskills), list,"");
    }

   

}
