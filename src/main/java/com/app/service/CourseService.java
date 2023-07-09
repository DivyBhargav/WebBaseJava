package com.app.service;

import java.util.List;

import com.app.entity.CourseEntity;

public interface CourseService {
	
	public List<CourseEntity> getAllCourse();
	
	public CourseEntity addNewCourse(CourseEntity course);
	
	public CourseEntity getCourseDetailById(Long Id);

	public String deleteCourse(Long Id);

	public CourseEntity upDateCourse(CourseEntity course);
	
	

}
