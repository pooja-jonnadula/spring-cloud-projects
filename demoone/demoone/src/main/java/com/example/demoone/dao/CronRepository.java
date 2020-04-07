package com.example.demoone.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.model.CronJob;
import com.example.model.Student;



@Component
public interface CronRepository  extends CrudRepository<CronJob, Integer>{

}
