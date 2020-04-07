package com.microserviceone.MicroServiceOne.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microserviceone.MicroServiceOne.model.Address;
import com.microserviceone.MicroServiceOne.model.EmployeeDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class ServiceOneController {

	@Autowired
	RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "callEmpService_Fallback" , 
    		commandProperties= {
    				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000")
    		,@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="6"),
    		@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="50"),
    		@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="6000")		
    })
	@GetMapping("/getEmpDtl/{id}")
	EmployeeDetails getEmpDtls(@PathVariable(value = "id") int id) {
    	EmployeeDetails empDtls =null;
    	try {
    		System.out.println("Time ->"+new Date());
		 empDtls = restTemplate.getForObject("http://ServiceTwo/getEmpDtls/" + id,
				EmployeeDetails.class);
    	}catch(Exception e ) {
    		System.out.println("Exceptn Time ->"+new Date());
    		e.printStackTrace();
    	}
		return empDtls;

	}
    EmployeeDetails callEmpService_Fallback(@PathVariable(value = "id") int id){
    	System.out.println("fallback call Time ->"+new Date());
    	EmployeeDetails empDtls = new  EmployeeDetails();
    	empDtls.setId(id);
    	empDtls.setName("Dummy Name CB Fallback");
    	Address addr=new Address();
    	addr.setFlatno("DDDDD");
    	addr.setLandmark("DDDD");
    	addr.setMobileno("0000000");
    	
    	empDtls.setAddr(addr);
    	// "Circuit Breaker Enabled!! Fallback method triggered";
		return empDtls;
    	
    }
}
