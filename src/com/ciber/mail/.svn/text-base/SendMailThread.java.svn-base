/**
 * 
 */
package com.ciber.mail;

import com.ciber.beans.User;

/**
 * @author ssunkara
 *
 */
public class SendMailThread extends Thread {
	private String toEmail;
	private String ccEmail;
	private String url;
	private User user; 
	private String toUserName;
	
	
	public SendMailThread(String toEmail, String ccEmail,String url,User user,String toUserName) {
		this.toEmail=toEmail;
		this.ccEmail=ccEmail;
		this.url=url;
		this.user=user;
		this.toUserName=toUserName;
	}
	@Override
	public void run() {
		System.out.println("thread is created for toEmail");
			MailNotification mail=new MailNotification();
			mail.sendMail(toEmail,url, user,toUserName);
			System.out.println("thread is end for toEmail");
	}

}
