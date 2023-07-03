package com.ripplestreet.studentinforest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ripplestreet.studentinforest.dto.Student;
import com.ripplestreet.studentinforest.dto.Subject;
import com.ripplestreet.studentinforest.exception.StudentInfoException;
import com.ripplestreet.studentinforest.model.StudentDetails;
import com.ripplestreet.studentinforest.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private Logger logger;

	public StudentDetails save(StudentDetails std) {
		Student s = new Student();
		s.setDOB(std.getDOB());
		s.setEmail(std.getEmail());
		s.setId(std.getId());
		s.setName(std.getName());
		s.setPhone(std.getPhone());
		s.setSubjects(std.getSubjects());
		studentRepository.save(s);
		return std;
	}

	public StudentDetails update(StudentDetails std) {
		Student s = new Student();
		s.setDOB(std.getDOB());
		s.setEmail(std.getEmail());
		s.setId(std.getId());
		s.setName(std.getName());
		s.setPhone(std.getPhone());
		s.setSubjects(std.getSubjects());
		studentRepository.save(s);
		return std;
	}

	public List<StudentDetails> getAll(){
		List<Student> studentInfoList = studentRepository.findAll();
		if(studentInfoList.isEmpty()) {
			logger.warn("List is empty");
			throw new StudentInfoException("List is empty",HttpStatus.NOT_FOUND);
		}
		else {
			List<StudentDetails> studentDetailsList =  new ArrayList<>();
			for(Student std : studentInfoList) {
				StudentDetails s = new StudentDetails();
				s.setDOB(std.getDOB());
				s.setEmail(std.getEmail());
				s.setId(std.getId());
				s.setName(std.getName());
				s.setPhone(std.getPhone());
				s.setSubjects(std.getSubjects());
				studentDetailsList.add(s);
			}
			return studentDetailsList;
		}
	}


	public ResponseEntity<StudentDetails> getById(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isEmpty()) {
			logger.warn("ID does not exists");
			throw new StudentInfoException("ID not found", HttpStatus.NOT_FOUND);
		}
		else {
			StudentDetails s = new StudentDetails();
			s.setDOB(student.get().getDOB());
			s.setEmail(student.get().getEmail());
			s.setId(student.get().getId());
			s.setName(student.get().getName());
			s.setPhone(student.get().getPhone());
			s.setSubjects(student.get().getSubjects());
			return ResponseEntity.of(Optional.of(s));
		}
	}


	public String deleteStudent(int id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.delete(student.get());
			logger.info("student deleted");
			return "student deleted";
		}
		else
			logger.warn("ID does not exists");
		throw new StudentInfoException("ID does not exists",HttpStatus.NOT_FOUND);
	}

	public List<StudentDetails> findByDOB(Date DOB){
		List<Student> list = studentRepository.findByDOB(DOB);
		if(list.isEmpty()) {
			logger.warn("No records for this DOB");	
			throw new StudentInfoException("no record for this DOB",HttpStatus.NOT_FOUND);
		}
		else {
			List<Student> studentInfoList =  studentRepository.findByDOB(DOB);
			List<StudentDetails> studentDetailsList =  new ArrayList<>();
			for(Student std : studentInfoList) {
				StudentDetails s = new StudentDetails();
				s.setDOB(std.getDOB());
				s.setEmail(std.getEmail());
				s.setId(std.getId());
				s.setName(std.getName());
				s.setPhone(std.getPhone());
				s.setSubjects(std.getSubjects());
				studentDetailsList.add(s);
			}
			return studentDetailsList;
		}
	}

	public int getCount() {
		return studentRepository.getCount();
	}

	public List<StudentDetails> getBySubjects(Subject subjects){
		List<Student> studentInfoList =  studentRepository.findBySubjects(subjects);
		List<StudentDetails> studentDetailsList =  new ArrayList<>();
		for(Student std : studentInfoList) {
			StudentDetails s = new StudentDetails();
			s.setDOB(std.getDOB());
			s.setEmail(std.getEmail());
			s.setId(std.getId());
			s.setName(std.getName());
			s.setPhone(std.getPhone());
			s.setSubjects(std.getSubjects());
			studentDetailsList.add(s);
		}
		return studentDetailsList;
	}

}
