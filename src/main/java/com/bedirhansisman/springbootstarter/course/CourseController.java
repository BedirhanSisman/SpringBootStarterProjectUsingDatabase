package com.bedirhansisman.springbootstarter.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bedirhansisman.springbootstarter.topics.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{ID}/courses")
	public List<Course> getCourses(@PathVariable String ID) {
		return courseService.getAllCourses(ID);
	}
	
	@RequestMapping("/topics/{topicID}/courses/{ID}")
	public Course getCourse(@PathVariable String ID) {
		return courseService.getCourse(ID);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicID}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicID) {
		course.setTopic(new Topic(topicID, "", ""));
		courseService.addCourse(course);		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicID}/courses/{ID}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicID) {
		course.setTopic(new Topic(topicID, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicID}/courses/{ID}")
	public void deleteCourse(@PathVariable String ID) {
		courseService.deleteCourse(ID);
	}
}
