package com.demo.SpringBootStudentRESRAPI.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.SpringBootStudentRESRAPI.Exception.InvalidStudent;
import com.demo.SpringBootStudentRESRAPI.model.Student;
import com.demo.SpringBootStudentRESRAPI.repository.StudRepository;
import com.demo.SpringBootStudentRESRAPI.service.StudService;

@Service
public class StudentServiceImp implements StudService{

	@Autowired
	StudRepository studRepos;
	
	@Override
	public Student addStud(Student stud) {
		// TODO Auto-generated method stub
	    Student studObj=studRepos.save(stud);
		return studObj;
	}

	@Override
	public List<Student> getAllStud() {
		// TODO Auto-generated method stub
		
		List<Student> a1=new ArrayList();
		List<Student> list=studRepos.findAll();
		Iterator<Student> itr= list.iterator();
		while(itr.hasNext())
		{
			a1.add(itr.next());
		}
		return a1;
	}


	public Student getStudById(@PathVariable long studId) throws InvalidStudent {
		// TODO Auto-generated method stub
		if(studRepos.existsById(studId))
		{
			Student stud=studRepos.findById(studId).get();
			return stud;
		}
		else {
			throw new InvalidStudent("Student not Present");
		}
	
	}

	@Override
	public int updateStud(long studId, Student newStud)throws InvalidStudent {
		// TODO Auto-generated method stub
		if(studRepos.existsById(studId))
		{
		  int status= studRepos.updateStudent(studId,
					newStud.getStudName(), 
					newStud.getStudAdd(), 
					newStud.getStudAge());
		  
		  return status;
		}
		else 
		{
		 throw new InvalidStudent("Not able to update");
		}
	}

	@Override
	public long delectStud(long studId) throws InvalidStudent {
		// TODO Auto-generated method stub
		if(studRepos.existsById(studId))
		{
			int status=studRepos.deleteStudent(studId);
			return status;
		}
		else
		{
		throw new InvalidStudent("Not able to Delete");
		}
	}

}
