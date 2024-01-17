package com.demo.SpringBootStudentRESRAPI.service;

import java.util.List;

import com.demo.SpringBootStudentRESRAPI.Exception.InvalidStudent;
import com.demo.SpringBootStudentRESRAPI.model.Student;

public interface StudService {
	
	public Student addStud(Student stud);
	public List<Student> getAllStud();
	public Student getStudById(long studId) throws InvalidStudent;
	public int updateStud(long studId, Student newStud)throws InvalidStudent;
	public long delectStud(long StudId) throws InvalidStudent;

}
