/**
 * 
 */
package com.ciber.quartz.service;

import com.ciber.quartz.dto.QuartzJobDTO;

/**
 * @author lmuriyal
 *
 */
public interface IJobLogService {
	
	public int logJobRequest(QuartzJobDTO jobDto);
	
	public void updateJobStatus(QuartzJobDTO jobDto);

}
