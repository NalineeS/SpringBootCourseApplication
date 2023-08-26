package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapi.model.Course;

public interface CourseService  {
	
	public List<Course> getCourses();

	public Course addCourse(Course course);


	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);


	public Optional<Course> getCourseById(long parseLong);

	public Optional<Course> getCourseByTitle(String title);

}
