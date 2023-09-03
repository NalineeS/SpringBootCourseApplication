package com.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restapi.model.Student;

@Repository
public interface StudentDaoRepository extends JpaRepository<Student,Integer> {
	
//	@Query("select s From student s where s.address = :address")
//	public List<Student> getUserByAddress(@Param("address") String address);

}
