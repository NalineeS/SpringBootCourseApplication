package com.restapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.StudentDaoRepository;
import com.restapi.model.Student;
import com.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDaoRepository studentDao;
	@Override
	public Student addStudent(Student student) {
		studentDao.save(student);
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		Student s=studentDao.getOne(studentId);
		studentDao.delete(s);
	}

	@Override
	public Student updateStudent(Student student) {
		studentDao.save(student);
		return student;
	}

	@Override
	public Optional<Student> getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.findById(studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}


//	@Override
//	public List<Student> getStudentsByAddress(String address) {
//		// TODO Auto-generated method stub
//		return studentDao.getUserByAddress(address);
//	}

}
