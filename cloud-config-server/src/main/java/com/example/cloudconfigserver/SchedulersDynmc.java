/*package com.example.cloudconfigserver;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class SchedulersDynmc implements SchedulingConfigurer {
	@Value("${cronJobExpn}")
	String cronJobExpn;
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		 taskRegistrar.addTriggerTask(new Runnable() {
	            @Override
	            public void run() {
	            	System.out.println("cron:"+cronJobExpn);
	             	System.out.println("Running Schedular JobLogic......"+new Date());
	            }
	        }, new CronTrigger(cronJobExpn)); 
		
	}

	
}
*/