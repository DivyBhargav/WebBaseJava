package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.entity.CourseEntity;
import com.app.repository.CourseRepository;
@Service
@Transactional
public class CourseServiceImp implements CourseService {
	
	@Autowired
	private CourseRepository crsrepo;

	@Override
	public List<CourseEntity> getAllCourse() {
		return crsrepo.findAll();
	}

	@Override
	public CourseEntity addNewCourse(CourseEntity course) {
		if(course.getEndDate().isBefore(course.getStratingDate()))
			throw new CustomException("End Date >StartDate");
		else
				return crsrepo.save(course);
	}

	@Override
	public CourseEntity getCourseDetailById(Long Id) {
		return crsrepo.findById(Id).orElseThrow(()->new CustomException("Invalid id"));
	}

	@Override
	public CourseEntity upDateCourse(CourseEntity course) {
		return crsrepo.save(course);
	}

	@Override
	public String deleteCourse(Long Id) {
		String msg = "Can not Delete";
		if(crsrepo.existsById(Id)) {
			crsrepo.deleteById(Id);
			msg = "Delete Successfully";
			}
		return msg;
	}

}
