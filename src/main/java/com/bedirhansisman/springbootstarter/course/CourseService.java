package com.bedirhansisman.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicID){
		List<Course> listOfCourses = new ArrayList<Course>();
		courseRepository.findByTopicID(topicID).forEach(listOfCourses::add);
		return listOfCourses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course); 
		//Repository will understand what is the process, update or add another one?
		//we don't need id parameter here.
	}

	public void deleteCourse(String iD) {
		courseRepository.delete(iD);
	}

}
