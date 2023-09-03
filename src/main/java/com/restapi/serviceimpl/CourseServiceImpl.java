package com.restapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.CourseDaoRepository;
import com.restapi.model.Course;
import com.restapi.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDaoRepository courseDaoRepo;

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDaoRepo.findAll();
	}

	@Override
	public Optional<Course> getCourseById(long id) {
		// TODO Auto-generated method stub
		return courseDaoRepo.findById(id);
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDaoRepo.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDaoRepo.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		Course entity=courseDaoRepo.getOne(parseLong);
		courseDaoRepo.delete(entity);
	}

	 public Optional<Course> getCourseByTitle(String title) {
	        return (Optional<Course>) courseDaoRepo.findByTitle(title);
	    }

// below code is without database coonection	
//	List<Course> list;
//	
//	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(100,"Java Developer","Course contains Spring boot rest api"));
//		list.add(new Course(101,"UI Developer","Course contains React Framework"));
//	}
//
//	@Override
//	public List<Course> getCourses() {
//		// TODO Auto-generated method stub
//		return list;
//	}
//
//	@Override
//	public Course getCourse(long courseId) {
//		// TODO Auto-generated method stub
//		Course c=null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
//	}
//
//	@Override
//	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
//	}
//
//	@Override
//	public Course updateCourse(Course course) {
//		for(Course c:list) {
//			if(c.getId()==course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDesc(course.getDesc());
//			}
//		}
//		return course;
//	}
//
//	@Override
//	public void deleteCourse(long parseLong) {
////		for(Course c:list) {
////			if(c.getId()==courseId){
////				list.remove(c);
////			}
////		}
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//	}


}

