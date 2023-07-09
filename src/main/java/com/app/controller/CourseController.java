package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CourseEntity;
import com.app.service.CourseServiceImp;

@RestController
@RequestMapping("course")
public class CourseController {
  @Autowired
  private CourseServiceImp crs;
  
  public CourseController() {
	System.out.println("in Course Controller");
}
  
 @GetMapping
 public ResponseEntity<?> getallCourse(){
	 System.out.println("in GetAll");
	 return ResponseEntity.status(HttpStatus.OK).body(crs.getAllCourse());
 }
 
 @GetMapping("/{Id}")
 public ResponseEntity<?> getDetailsById(@PathVariable Long id)
 {
	 System.out.println("In get by id");
	 return ResponseEntity.status(HttpStatus.OK).body(crs.getCourseDetailById(id));
 }
 
 @PostMapping
 public ResponseEntity<?> AddNewCourse(CourseEntity course){
	 System.out.println( "in Add new Course");
	 return ResponseEntity.status(HttpStatus.OK).body(crs.addNewCourse(course));
 }
 
 @PutMapping
 public ResponseEntity<?>UpDateCourse(@RequestBody CourseEntity course){
	 System.out.println("In Update");
	 return ResponseEntity.status(HttpStatus.OK).body(crs.upDateCourse(course));
 }
 
 @DeleteMapping
 public ResponseEntity<?> deleteCourse(@PathVariable Long id){
	 System.out.println("in Delete");
	 return ResponseEntity.status(HttpStatus.OK).body(crs.deleteCourse(id));
 }

}
