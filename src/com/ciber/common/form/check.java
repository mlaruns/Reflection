package com.ciber.common.form;

import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ciber.beans.User;
public class check extends ActionForm {

		private static final long serialVersionUID = 1L;
		private String userName = null;
	    private String password= null;
	    private String error= null;
	    User user = new User();
	    public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		
		public void reset(ActionMapping mapping, HttpServletRequest request) {
			this.userName = null;
			this.password = null;
		}
		
		public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	        ActionErrors errors = new ActionErrors();
	        if ((userName == null || userName.length() < 1) && (password == null || password.length() < 1)) {			    
				errors.add("userName", new ActionMessage("error.userName.required"));
				errors.add("password", new ActionMessage("error.password.required"));         
	        }else if(password == null || password.length() < 1) {
	            errors.add("password", new ActionMessage("error.password.required"));       
	        }
			else if (userName == null || userName.length() < 1) {
	            errors.add("userName", new ActionMessage("error.userName.required"));
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
