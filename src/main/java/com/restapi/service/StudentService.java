package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.restapi.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public void deleteStudent(int studentId);
	
	public Student updateStudent(Student student);
	
	public Optional<Student> getStudentById(int studentId);
	
	public List<Student> getAllStudents();
	
//	public List<Student> getStudentsByAddress(String address);
	

}
