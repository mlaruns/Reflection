package com.ciber.common.form;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ciber.beans.User;

public class LoginForm extends org.apache.struts.action.ActionForm
{
	
	private static final long serialVersionUID = 1L;
	private String userName;
    private String password;
    private String error;
    User user = new User();
    public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		
        ActionErrors errors = new ActionErrors();
        if ((userName == null || userName.length() < 1) || (password == null || password.length() < 1))
        {			    
			errors.add("userName", new ActionMessage("error.user.required"));
        }
        return errors;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}