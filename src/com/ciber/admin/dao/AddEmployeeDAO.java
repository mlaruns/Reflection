package com.ciber.admin.dao;

import com.ciber.admin.form.ApplicationModel;
import com.ciber.beans.EmployeeList;

public interface AddEmployeeDAO {
	
	public boolean addEmployeeList(EmployeeList list,String appID);

}
