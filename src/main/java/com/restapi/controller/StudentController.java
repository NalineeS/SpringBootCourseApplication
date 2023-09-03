package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import com.restapi.model.Student;
import com.restapi.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	//add new Student
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return student;
	}
	
	//Get student by id
	@GetMapping("getbyid/{studentId}")
	public Optional<Student> getStudentById(@PathVariable String studentId) {
		return studentService.getStudentById(Integer.parseInt(studentId));
		
	}
	//get All students
	@GetMapping("/getallstudents")
	public List<Student> getAllStudents(){
		return this.studentService.getAllStudents();
	}
	//update student
	@PutMapping("update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	//delete Student
	@DeleteMapping("delete/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId){
	try {
		this.studentService.deleteStudent(Integer.parseInt(studentId));
		return new ResponseEntity<>(HttpStatus.OK);
	}catch(Exception e){
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	//get student list by address
//	@GetMapping("/getbyaddress/{address}")
//	public List<Student> getStudentByaddress(@PathVariable String address){
//		return studentService.getStudentsByAddress(address);
//	}
}