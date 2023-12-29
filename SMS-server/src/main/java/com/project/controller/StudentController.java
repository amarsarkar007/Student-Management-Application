package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.service.IStudentService;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		
		return new ResponseEntity<List<Student>>(studentService.getStudents(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		return new ResponseEntity<Student>(studentService.addStudent(student),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable Long id){
		
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.ACCEPTED);		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		
		return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.FOUND);
	}

	
	
	
	
	
	
	

}
