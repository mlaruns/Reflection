/**
 * 
 */
package com.ciber.quartz.service;

import com.ciber.quartz.dao.JobLogDaoImpl;
import com.ciber.quartz.dto.QuartzJobDTO;

/**
 * @author lmuriyal
 *
 */
public class JobLogServiceImpl implements IJobLogService{

	@Override
	public int logJobRequest(QuartzJobDTO jobDto) {
		return new JobLogDaoImpl().logJobRequest(jobDto);
	}

	@Override
	public void updateJobStatus(QuartzJobDTO jobDto) {
		 new JobLogDaoImpl().updateJobStatus(jobDto);
		
	}

}
