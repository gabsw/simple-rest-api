package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	// spring recommends using injection through constructors
	// if that is not possible, then through setters
	@Autowired
	private CourseService courseService;

	// @...... (cant remember the annotation, look for "spring constructor injection"
	// public TopicController(TopicService topicService) {
	// 	this.topicService = topicService;
	// }
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		
		// automatically converted to JSON
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course newCourse, @PathVariable String topicId) {
		
		newCourse.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(newCourse);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course updatedCourse,
			@PathVariable String topicId, @PathVariable String id) {
		updatedCourse.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(updatedCourse);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
