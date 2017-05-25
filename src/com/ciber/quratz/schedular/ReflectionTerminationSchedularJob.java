/**
 * 
 */
package com.ciber.quratz.schedular;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import com.ciber.quartz.dto.QuartzJobDTO;
import com.ciber.quartz.service.IJobLogService;
import com.ciber.quartz.service.JobLogServiceImpl;
import com.ciber.service.JDBCService;

/**
 * @author lmuriyal
 *
 */
public class ReflectionTerminationSchedularJob implements Job {

	public static final String JOB_NAME = "Reflection_Termination_Job";
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

			// Get All Eligibale Application ID for termination

			List<Integer> terminationIds = new JDBCService().getEligibleApplicationIdsForTermination();

			StringBuilder comments = new StringBuilder();

			// Iterator over each termination IDs and terminate
			if (terminationIds != null && !terminationIds.isEmpty()) {
				comments.append("Reflection Ids which needs to be terminated are :: ");
				JDBCService aService = new JDBCService();
				for (Integer id : terminationIds) {
					aService.stopApplication(String.valueOf(id));
					comments.append(String.valueOf(id) + ";");
				}

			} else {
				System.out.println(" We do not have any Eligible Reflection Ids to terminate...");
				comments.append("We do not have any Eligible Reflection Ids to terminate...");

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
