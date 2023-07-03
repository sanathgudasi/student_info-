package com.ripplestreet.studentinforest.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ripplestreet.studentinforest.dto.Subject;
import com.ripplestreet.studentinforest.model.StudentDetails;
import com.ripplestreet.studentinforest.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	public Logger logger;

	@PostMapping("/save")
	public StudentDetails save(@Valid  @RequestBody StudentDetails student) {
		logger.info("student saved"+student);
		return studentService.save(student);
	}

	@PutMapping("/update")
	public StudentDetails update(@Valid  @RequestBody StudentDetails student) {
		logger.info("student updated");
		return studentService.update(student);
	}

	@GetMapping("getAll/")
	public List<StudentDetails> getAll(){
		return studentService.getAll();
	}

	@GetMapping("getByID/{id}")
	public ResponseEntity<StudentDetails> getById(@PathVariable int id){
		return studentService.getById(id);
	}

	@DeleteMapping("delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/dob/{DOB}")
	public List<StudentDetails> getByDOB(@PathVariable   @DateTimeFormat(pattern = "yyyy-MM-dd")Date DOB){
		return studentService.findByDOB(DOB);
	}

	@GetMapping("/count")
	public String getCount() {
		return "Total student count: "+studentService.getCount();
	}

	@GetMapping("/subjects")
	public List<StudentDetails> getBySubjects(@RequestParam("subjects") Subject subjects){
		return studentService.getBySubjects(subjects);
	}


}
