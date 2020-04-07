package com.example.cloudconfigclient;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@Configuration
@Component
public class SchedulersDynmc implements SchedulingConfigurer {
	@Value("${cronJobExpn}")
	String cronJobExpn;
	@Autowired
	Controller contrlr;
	
	@PostConstruct
	void init(){
		System.out.println("cronJobExpn in init:"+cronJobExpn);
	}
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		try {
		 taskRegistrar.addTriggerTask(new Runnable() {
	            @Override
	            public void run() {
	            	System.out.println("cron:"+contrlr.getCronJobExpn());
	             	System.out.println("Running Schedular JobLogic......"+new Date());
	            }
	        }, 
				 
new Trigger() {
				
				@Override
				public Date nextExecutionTime(TriggerContext triggerContext) {
	                Calendar nextExecutionTime = new GregorianCalendar();
	                System.out.println("let::"+triggerContext.lastActualExecutionTime());
	                Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
	                boolean lastExDtTom=false;
	                if(lastActualExecutionTime!=null ) {
	            	   lastExDtTom=lastActualExecutionTime.before(new Date());
		                System.out.println("lastExDtTom:"+lastExDtTom);
		                
		                   
	               }
	                if( lastActualExecutionTime==null) {
	                	lastExDtTom=true;
	                	System.out.println("count = 1");
	                }
	                
	                else {
	                	System.out.println("count = 2+ "+lastActualExecutionTime);
	                	lastExDtTom=true;
	                }
	                if(lastExDtTom ) {
	                nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
	                nextExecutionTime.add(Calendar.MILLISECOND, getNewExecutionTime());
	                
	               // System.out.println("count:"+count);
	                System.out.println("nET::"+nextExecutionTime.getTime());
	                return nextExecutionTime.getTime();
	            }
	                else {
		            	System.out.println("null---");
	                	return null;
		            	
		            	
		            }}

				private int getNewExecutionTime() {
					System.out.println("new extn time::"+contrlr.getCronJobExpn());
					return Integer.parseInt(contrlr.getCronJobExpn());
				}
	            
	        }); 
		
	}catch(Exception e ) {e.printStackTrace();}
	}
	
}
