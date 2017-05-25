/**
 * 
 */
package com.ciber.quratz.schedular;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import com.ciber.mail.MailNotification;
import com.ciber.quartz.dto.EmailReminderDto;
import com.ciber.quartz.dto.QuartzJobDTO;
import com.ciber.quartz.service.EmailServiceImpl;
import com.ciber.quartz.service.IEmailService;
import com.ciber.quartz.service.IJobLogService;
import com.ciber.quartz.service.JobLogServiceImpl;

/**
 * @author lmuriyal
 *
 */
public class SchedulerJob implements Job {

	public static final String JOB_NAME = "emailNotification_Job";
	public static final String IN_PROGRESS = "IN_PROGRESS";
	public static final String COMPLETED = "COMPLETED";
	public static final String FAILED = "FAILED";

	public void execute(JobExecutionContext context) {

		QuartzJobDTO jobDto = new QuartzJobDTO();

		IJobLogService jobLogService = new JobLogServiceImpl();

		int jobID = 0;

		try {

			System.out.println(" Fired Job start date and time ##### " + new Date());

			Long startTime = System.currentTimeMillis();

			// Log the Job request
			jobDto.setJobName(JOB_NAME);
			jobDto.setJobStatus(IN_PROGRESS);
			jobDto.setStartDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));

			jobID = jobLogService.logJobRequest(jobDto);

			// Get All eligible employee names and send email notification
			IEmailService emailService = new EmailServiceImpl();

			List<EmailReminderDto> employeeList = emailService.getElegibleEmployeeListForNotification();

			StringBuilder comments = new StringBuilder();

			if (employeeList != null && !employeeList.isEmpty()) {

				MailNotification mail = null;

				for (EmailReminderDto employee : employeeList) {
					mail = new MailNotification();
					mail.sendReminderEmail(employee.getEmployeeEmailID(), employee.getEmployeeName(),
							employee.getReflectionEmpName());

					comments.append("[ " + employee.getAppID() + ":: " + employee.getEmployeeEmailID() + " ]");

				}

			}

			else {
				System.out.println(" We do not have any Eligible employees to send an email...");
				comments.append("We do not have any Eligible employees to send an email...");

			}

			// update the job status
			jobDto.setJobID(jobID);
			jobDto.setComments(comments.toString());
			jobDto.setJobStatus(COMPLETED);
			jobDto.setEndDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));

			Long endTime = System.currentTimeMillis();

			System.out
					.println(" Total time taken by the job to complete the task ##### " + (endTime - startTime) / 1000);

		} catch (Exception e) {

			jobDto.setJobID(jobID);
			jobDto.setErrorDetails(e.getMessage());
			jobDto.setJobStatus(FAILED);
			jobDto.setEndDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));

		} finally {
			jobLogService.updateJobStatus(jobDto);
		}

	}
}
