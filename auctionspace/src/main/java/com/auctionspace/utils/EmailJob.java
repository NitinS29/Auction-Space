package com.auctionspace.utils;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmailJob implements Job{
	private static Logger logger = Logger.getLogger(EmailJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try{
			EmailTask emailTask = new EmailTask();
			logger.info("In EmailJob execute");
			emailTask.sendMailToSellers();
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			logger.error("Error in EmailJob" + exceptionAsString);
		}
	}
}
