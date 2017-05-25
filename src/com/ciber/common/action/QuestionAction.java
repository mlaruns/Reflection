package com.ciber.common.action;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ciber.beans.Questions;

public class QuestionAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		Enumeration<String> enumeration=request.getParameterNames();
		Map<String,Questions> map=(Map) request.getSession().getAttribute("QuestionsMap");
		String johariAns =null;
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			if(!"pager.offset".equalsIgnoreCase(string) && !"jwal".equalsIgnoreCase(string)){
				Questions questions=map.get(string);
				questions.setAnswer(request.getParameter(string));
				map.put(string, questions);
			}
			
			if("jwal".equalsIgnoreCase(string)){
				johariAns = request.getParameter(string);
			}
		}
		request.getSession().setAttribute("JohariAns",johariAns);
		request.getSession().setAttribute("QuestionsMap",map);
		return mapping.findForward("success");
	}
}