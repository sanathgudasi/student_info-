package com.ripplestreet.studentinforest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ripplestreet.studentinforest.dto.Student;
import com.ripplestreet.studentinforest.dto.Subject;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByDOB(Date DOB);
	
	@Query("select count(s) from Student s")
	public int getCount();
	
	@Query("select s from Student s WHERE s.subjects IN :subjects")
	public List<Student> findBySubjects(@Param("subjects")  Subject subjects);
	
}
