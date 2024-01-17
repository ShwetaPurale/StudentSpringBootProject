package com.demo.SpringBootStudentRESRAPI.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Student_table")
public class Student {
	
	@Id	
	private long studId;
	
	@NotBlank(message = "Enter student name")
	private String studName;
	
	@NotNull(message = "Address should not be null")
	private String studAdd;
		
	private int studAge;

	public Student(long studId, @NotBlank(message = "Enter student name") String studName,
			@NotNull(message = "Address should not be null") String studAdd, int studAge) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAdd = studAdd;
		this.studAge = studAge;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudAdd() {
		return studAdd;
	}

	public void setStudAdd(String studAdd) {
		this.studAdd = studAdd;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAdd=" + studAdd + ", studAge=" + studAge
				+ "]";
	}
	
		
}
