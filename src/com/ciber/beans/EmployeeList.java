package com.ciber.beans;

import java.io.Serializable;

public class EmployeeList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String empID;
	private String role;
	private String empName;
	private String empNo;
	private String email;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}
	@Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof EmployeeList)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        EmployeeList c = (EmployeeList) o;
         
        // Compare the data members and return accordingly 
        return empID.equals(c.getEmpID());
    }
	 public int hashCode() {
		    int result = 0;
		    result = (int)(empID.hashCode()/12) + empID.hashCode();
		    return result;
		  }
	
}
