package com.ciber.exception.ExcelException;

public class ExcelException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg = null;

	public String getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

	public ExcelException()
	{}

	public ExcelException(String errorMsg, Throwable cause)
	{
		super(errorMsg, cause);
		
		this.errorMsg = errorMsg;
	}

	public ExcelException(String errorMsg)
	{
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public ExcelException(Throwable cause)
	{
		super(cause);
	}
}