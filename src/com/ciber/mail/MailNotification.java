package com.ciber.mail;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.ciber.beans.User;

public class MailNotification {

	private static MailNotification mails = new MailNotification();
	/*
	 * private final String USERNAME = null; private final String PASSWORD =
	 * null;
	 */
	private Session session = null;
	ResourceBundle bundle = ResourceBundle.getBundle("com/ciber/properties/ApplicationResource");

	public MailNotification() {
	}

	private Session getSesssion() {
		if (session == null) {
			Properties props = new Properties();
			props.put(bundle.getString("mail.starttls"), "true");
			props.put(bundle.getString("mail.port"), 25);
			props.put(bundle.getString("mail.host"), bundle.getString("mail.smtpAddress"));
			props.put(bundle.getString("mail.auth"), "true");
			// props.put("mail.debug", "true");
			Authenticator authenticator = new Authenticator(bundle.getString("emailUser"),
					bundle.getString("emailPassword"));
			props.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
			session = Session.getInstance(props, authenticator);
		}
		return session;
	}

	public static MailNotification getInstance() {
		return mails;
	}

	private class Authenticator extends javax.mail.Authenticator {
		private PasswordAuthentication authentication;

		public Authenticator(String userName, String password) {
			authentication = new PasswordAuthentication(userName, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}

	public void sendMail(String toEmail, String url, User user, String toName) {
		getSesssion();
		try {
			String body = bundle.getString("mail.body");
			body = body.replace("Employee", toName);
			body = body.replace("Name", user.getEname());
			// body=body.replace("URL", url);
			MimeMessage message = new MimeMessage(session);
			Multipart multiPart = new MimeMultipart("alternative");
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body, "text/html; charset=utf-8");
			multiPart.addBodyPart(htmlPart);
			message.setContent(multiPart);
			message.setFrom(new InternetAddress(bundle.getString("emailUser")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(bundle.getString("mail.subject"));
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendReminderEmail(String employeeEmail, String empName, String refEmpName) throws MessagingException {
		getSesssion();

		String body = bundle.getString("email.reminder.body");
		body = body.replace("Employee", empName);
		body = body.replace("Name", refEmpName);
		// body=body.replace("URL", url);
		MimeMessage message = new MimeMessage(session);
		Multipart multiPart = new MimeMultipart("alternative");
		MimeBodyPart htmlPart = new MimeBodyPart();
		htmlPart.setContent(body, "text/html; charset=utf-8");
		multiPart.addBodyPart(htmlPart);
		message.setContent(multiPart);
		message.setFrom(new InternetAddress(bundle.getString("emailUser")));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(employeeEmail));
		message.setSubject(bundle.getString("mail.subject"));
		Transport.send(message);

	}

}