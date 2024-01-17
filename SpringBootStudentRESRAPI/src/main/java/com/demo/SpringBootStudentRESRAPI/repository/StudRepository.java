package com.demo.SpringBootStudentRESRAPI.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.SpringBootStudentRESRAPI.model.Student;

public interface StudRepository extends JpaRepository<Student, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Student s SET  s.studName=:sName, "
			+ "s.studAdd=:sAdd, s.studAge=:sAge WHERE s.studId=:sId")
	public int updateStudent(@Param("sId") long sId, @Param("sName") String sName, 
			@Param("sAdd") String sAdd, @Param("sAge") int sAge);
	
	
	@Transactional
	@Modifying
	@Query("DELETE Student s WHERE s.studId=:sId")
	public int deleteStudent(@Param("sId")long studId);

}
