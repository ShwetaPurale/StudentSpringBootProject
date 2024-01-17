package com.demo.SpringBootStudentRESRAPI.Exception;

public class InvalidStudent extends Exception{
	
	public InvalidStudent(String errorMsg)
	{
		super(errorMsg);
	}

}
