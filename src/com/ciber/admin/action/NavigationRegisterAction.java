/**
 * 
 */
package com.ciber.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ciber.beans.User;
import com.ciber.beans.UserApplicationList;
import com.ciber.service.JDBCService;

/**
 * @author ssunkara
 *
 */
public class NavigationRegisterAction extends Action {
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession httpSession = request.getSession();
		User user=(User)httpSession.getAttribute("user");
		ArrayList<UserApplicationList> obj=new JDBCService().currentApplicationsUsr(user,user.getUserId());
		request.getSession().setAttribute("currentList", obj);
		return mapping.findForward(SUCCESS);
	}

}
