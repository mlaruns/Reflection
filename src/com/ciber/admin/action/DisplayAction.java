package com.ciber.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ciber.beans.JohariWidowAdjectives;
import com.ciber.beans.Questions;
import com.ciber.beans.User;
import com.ciber.service.JDBCService;

public class DisplayAction  extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		Map<String,Questions> map=null;
		List<JohariWidowAdjectives> johariWidowList= null;
		JDBCService jdbcService = new  JDBCService();
		
		
		String appId=request.getParameter("appId");
		String appType=request.getParameter("appType");
		String role=request.getParameter("role");
		//UserRegisterForm registration=(UserRegisterForm) request.getSession().getAttribute("registerForm");
		User user=(User)request.getSession().getAttribute("user");
	request.getSession().setAttribute("answers", new HashMap<String, String>());
	map = jdbcService.retrieveQuestions(appId,user.getEmployeeId(),role);
	// get get Johari Widow Adjectives
	johariWidowList = jdbcService.getJohariWidowAdjectives();
	request.getSession().setAttribute("QuestionsMap",map);
	request.getSession().setAttribute("applicationId", appId);
	request.getSession().setAttribute("appType", appType);
	request.getSession().setAttribute("value", 1);
	request.getSession().setAttribute("JohariWidowList",johariWidowList);
	int flag =  new JDBCService().flagCheckUser(appId,user.getEmployeeId(),role);
	request.getSession().setAttribute("flag",flag);
	if(flag==1){
		List<Questions> questions = new JDBCService().getQuestions(appId,user.getEmployeeId(),role);
		request.getSession().setAttribute("viewQuestions", questions);
		String  johAns = new JDBCService().getJohariUserAns(appId,user.getEmployeeId());
		request.getSession().setAttribute("viewJohAns", johAns);
		return mapping.findForward("view");
	}
	else{
	return mapping.findForward("success");
	}
	}
}
