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
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Course;
import com.restapi.service.CourseService;

@RestController
public class CoursesController {
	//autowired will tell spring boot that you create object of this interface Impl. class for me according to dependency injection
	//spring boot automatically create obj of impl class and inject it into courseService Interface for loose Coupling
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Courses Application";
	}
	
	//get All courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
	}
	//get single Course
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable(value="courseId") String courseId) {
		 return (Optional<Course>) this.courseService.getCourseById(Long.parseLong(courseId));
	 }
		
	//Add new Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
//	@GetMapping("/getcoursebytitle/{title}")
//	public Optional<Course> getCourseByTitle(@PathVariable(value="title") String title ){
//		return (Optional<Course>) this.courseService.getCourseByTitle(title);
//		
//	}
	
	@GetMapping("/courses/title/{courseTitle}")
    public ResponseEntity<Course> getCourseByName(@PathVariable String courseTitle) {
        Optional<Course> course = courseService.getCourseByTitle(courseTitle);
        
        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	//update course using put mapping
	@PutMapping("/courses")
	public Course updateCourse1(@RequestBody Course course) {
		return this.courseService.updateCourse(course);			
	}
	
	//Delete the Course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
	try {
		this.courseService.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
	}catch(Exception e){
		return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
