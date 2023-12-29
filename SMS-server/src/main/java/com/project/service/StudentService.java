package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.StudentAlreadyExistsException;
import com.project.exception.StudentNotFoundException;
import com.project.model.Student;
import com.project.repository.StudentRepository;


@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		
		if(studentAlreadyExists(student.getEmail())) {
			
			throw new StudentAlreadyExistsException(student.getEmail()+" already exists !");
		}
		
		return studentRepository.save(student);
	}

	

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
	
		Optional<Student> s = studentRepository.findById(id);
		
		if(s.isEmpty()) {
			throw new StudentNotFoundException("Sorry, no student found with id : "+id);
		}else {
			
			Student st = s.get();
			
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());

			return studentRepository.save(st);			
		}			
	}

	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Sorry, no student found with id : "+id));
	}

	@Override
	public void deleteStudent(Long id) {
		
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("No student found with id : "+id);		
		}else {
			studentRepository.delete(studentRepository.findById(id).get());
		}		
	}
	
	private boolean studentAlreadyExists(String email) {
		
		return studentRepository.findByEmail(email).isPresent();
	}

}
