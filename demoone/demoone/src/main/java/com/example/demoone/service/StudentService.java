package com.example.demoone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoone.dao.CronRepository;
import com.example.demoone.dao.StudentRepository;
import com.example.model.Student;




@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	@Autowired 
	CronRepository cronRepository;
	//getting all student records
	public List<Student> getAllStudent() 
	{
	List<Student> students = new ArrayList<Student>();
	studentRepository.findAll().forEach(student -> students.add(student));
	return students;
	}
	//getting a specific record
	public Student getStudentById(int id) 
	{
	return studentRepository.findById(id).get();
	}
	public void saveOrUpdate(Student student) 
	{
	studentRepository.save(student);
	}
	//deleting a specific record
	public void delete(int id) 
	{
	studentRepository.deleteById(id);
	}
	
	public String getCron(int id) {
		String re=null;
		try{
		re=  cronRepository.findById(1).get().getCronexpn() ;
	}catch(Exception e) {
		e.printStackTrace();
	System.out.println("no val in db");
	re="0 * * ? * *";
	}
		return re;
	}
}
