package com.ciber.common.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ciber.beans.Questions;
import com.ciber.beans.User;
import com.ciber.service.JDBCService;

public class CheckAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		Map<String,Questions> map=(Map) request.getSession().getAttribute("QuestionsMap");
		String applicationId=(String) request.getSession().getAttribute("applicationId");
		String appType=(String)request.getSession().getAttribute("appType");
        String johariAns = (String)request.getSession().getAttribute("JohariAns");
		User user = (User)request.getSession().getAttribute("user");
		String username = user.getEmployeeId();
		Boolean result = false;
		String count=(String)request.getSession().getAttribute("Count");
		
//		int falgCheck=new JDBCService().flagCheck(applicationId);
		if(map!=null ){
//			if(falgCheck==0){
			
				result = new JDBCService().insertAnswers(username,map,applicationId);
				result = new JDBCService().insertJohariAnswers(username,johariAns,applicationId);
				count = new JDBCService().checkAnswerCount(username,map,applicationId);
				new JDBCService().updateApplicationStatus(username, map, applicationId,count);
				
//			}
			if(count==null || count == "null"){
				count= "0";
			}
			request.getSession().setAttribute("Count", count);
			return mapping.findForward("success");
		}else
		{
		return mapping.findForward("failure");
		}
	}
}