package com.project.service;

import java.util.List;

import com.project.model.Student;

public interface IStudentService {
	
	Student addStudent(Student student);
	
	List<Student> getStudents();
	
	Student updateStudent(Student student, Long id);
	
	Student getStudentById(Long id);
	
	void deleteStudent(Long id);

}
