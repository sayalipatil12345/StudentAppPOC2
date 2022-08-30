package com.springboot.jwt.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jwt.entity.Student;
import com.springboot.jwt.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostConstruct
	public void initRoleAndUser() {
		studentService.initRoleAndUser();
	}

	@PostMapping({"/registerNewStudent"})
	public Student registerNewStudent(@RequestBody Student student) {
		return studentService.registerNewStudent(student);
	}

	@GetMapping("/getStudentById/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable(name="studentId") String studentId){
		Student student=this.studentService.getStudent(studentId);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}

	@PreAuthorize("hasRole('Admin')")
	@GetMapping("/forAdmin/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students=this.studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}


}