/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciber.admin.form;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends org.apache.struts.action.ActionForm implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormFile file;
    private String application;
    /**
	 * @return the applicationList
	 */
	public ArrayList<ApplicationModel> getApplicationList() {
		return applicationList;
	}

	/**
	 * @param applicationList the applicationList to set
	 */
	public void setApplicationList(ArrayList<ApplicationModel> applicationList) {
		this.applicationList = applicationList;
	}

	private ArrayList<ApplicationModel> applicationList;
    /**
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(String application) {
		this.application = application;
	}


    public FileUploadForm() {
        super();
    }

    /**
     * @return the file
     */
    public FormFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(FormFile file) {
        this.file = file;
    }

    /*public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (file.getFileSize() == 0) {
            errors.add("file", new ActionMessage("error.file.required"));
        } else if (!file.getContentType().equals("application/vnd.ms-excel")) {
            errors.add("file", new ActionMessage("error.file.type"));
        }
        *//**
         * If the file size is greater than 20kb.
         *//*
        else if (file.getFileSize() > 20480)
        {
            errors.add("file", new ActionMessage("error.file.size"));
        }
        return errors;
    }*/
}
