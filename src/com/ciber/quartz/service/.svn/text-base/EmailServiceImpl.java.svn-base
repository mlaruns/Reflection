/**
 * 
 */
package com.ciber.quartz.service;

import java.util.Collections;
import java.util.List;

import com.ciber.quartz.dao.EmailDaoImpl;
import com.ciber.quartz.dao.IEmailDao;
import com.ciber.quartz.dto.EmailReminderDto;

/**
 * @author lmuriyal
 *
 */
public class EmailServiceImpl implements IEmailService {

	@Override
	public List<EmailReminderDto> getElegibleEmployeeListForNotification() {

		IEmailDao emailDao = new EmailDaoImpl();
		List<EmailReminderDto> employeeList = emailDao.getElegibleEmployeeListForNotification();
		if (employeeList == null || employeeList.isEmpty()) {
			return Collections.EMPTY_LIST;
		} else {
			return employeeList;
		}

	}

}
