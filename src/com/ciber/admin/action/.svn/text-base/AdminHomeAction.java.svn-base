package com.ciber.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.User;
import com.ciber.service.JDBCService;

public class AdminHomeAction extends org.apache.struts.action.Action {
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
       
		User userDetails=(User)request.getSession().getAttribute("user");
		request.getSession().removeAttribute("showCount");
		ArrayList<ApplicationModel> obj=new JDBCService().currentApplications(userDetails);
		request.getSession().setAttribute("currentApp", obj);
		if(obj.size()==1){
			ApplicationModel model=obj.get(0);
			boolean flag=model.isShowCount();
			int respondentCount=Integer.valueOf(model.getRespondedCount());
			request.getSession().setAttribute("showCount", flag);
		}
		
            return mapping.findForward(SUCCESS);

	}
}





















/*package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.beans.User;
import com.ciber.AdminLoginForm;
import com.service.LoginService;

public class AdminLoginAction extends org.apache.struts.action.Action {
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";
	//AdminLoginModel obAdminLoginModel;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
		//AdminLoginModel obAdminLoginModel;
        AdminLoginForm loginForm = (AdminLoginForm) form;  
        User user=new User();
        user.setUserName(loginForm.getUserName());
        user.setPassword(loginForm.getPassword());
      
        if (new LoginService().isLoginValid(user)) {
        	request.getSession().setAttribute("user", user);
            return mapping.findForward(SUCCESS);
        } 
        else {
        	request.setAttribute("failure", "failure");
            return mapping.findForward(FAILURE);
        }
    }

}
*/