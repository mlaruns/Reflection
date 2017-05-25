/**
 * 
 */
package com.ciber.quratz.schedular;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lmuriyal
 *
 */
public class QuartzPlugin implements PlugIn {

	@Override
	public void destroy() {
		// null
	}

	@Override
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {

		JobDetail job = JobBuilder.newJob(SchedulerJob.class).withIdentity("emailNotification_Job", "ciber").build();

		try {

			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("emailNotification_Tgr", "ciber").withSchedule(
					CronScheduleBuilder.cronSchedule("0 0 12 * * ?").withMisfireHandlingInstructionFireAndProceed())
					.build();

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
