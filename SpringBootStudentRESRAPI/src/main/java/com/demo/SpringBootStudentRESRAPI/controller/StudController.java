package com.demo.SpringBootStudentRESRAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootStudentRESRAPI.Exception.InvalidStudent;
import com.demo.SpringBootStudentRESRAPI.dao.StudentServiceImp;
import com.demo.SpringBootStudentRESRAPI.model.Student;
import com.demo.SpringBootStudentRESRAPI.repository.StudRepository;

@RestController
@RequestMapping("/api")
public class StudController {
	
	@Autowired
     private StudentServiceImp studService;
	
//	url="localhost:3450/api/addStud"
	@PostMapping("/addStud")
	public Student createStudent(@RequestBody Student stud)
	{
		Student studObj=studService.addStud(stud);
		return studObj;
	}
	
//	url="localhost:3450/api/getAllStud"
	@GetMapping(path = "/getAllStud")
	public List<Student> getAllStudent()
	{		
		return studService.getAllStud();
		
	}
	
//	url="localhost:3450/api/getStudById/1"
	@GetMapping("/getStudById/{sId}")
	public Student getStudentById(@PathVariable long sId) throws InvalidStudent
	{
		return studService.getStudById(sId);
		
	}
	
//	url="localhost:3450/api/updateStudById/1"
	@PutMapping("/updateStudById/{sId}")
	public String updateStudById(@PathVariable long sId, @RequestBody Student stud) throws InvalidStudent
	{
		int status=studService.updateStud(sId, stud);
		if(status>0)
		{
			return "Student updated Successfully";
		}
		return "Student not updated";		
	}
	
	
//	url="localhost:3450/api/deleteStudById/1"
	@DeleteMapping("/deleteStudById/{sId}")
	public String deleteTrain(@PathVariable long sId) throws InvalidStudent
	{
		long status=studService.delectStud(sId);
		if(status>0)
		{
			return "Student Deleted Successfully";
		}
		return "Not able to delete";
		
	}

		
}
