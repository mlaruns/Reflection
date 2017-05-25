package com.ciber.beans;

import java.io.Serializable;

public class ImprovementOptions  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int optionID;
	private String optionName;
	public int getOptionID() {
		return optionID;
	}
	public void setOptionID(int optionID) {
		this.optionID = optionID;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	} 
	

}
