package com.example.cloudconfigclient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class Controller {
	@Autowired
	SchedulersDynmc dync;
	@Value("${cronJobExpn}")
	String cronJobExpn;

/*	@Value("${testname}")
	String testname;
*/

@GetMapping("/get")
String getServerVAl() {
	System.out.println("serverTest::"+cronJobExpn);
	
	return cronJobExpn;
}

public String getCronJobExpn() {
	System.out.println("cron::::"+cronJobExpn);
	return cronJobExpn;
}
/*@Scheduled(cron = "${cronJobExpn}")
public void cronJobSch() throws Exception {
	System.out.println("Cron Job Triggerred for every DYNAMICC ->Date and Time :: "+new Date());
}
*/}