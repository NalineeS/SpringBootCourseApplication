package com.restapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.model.Course;


@Repository
public interface CourseDaoRepository extends JpaRepository<Course, Long> {
	 Optional<Course> findByTitle(String title);
}
