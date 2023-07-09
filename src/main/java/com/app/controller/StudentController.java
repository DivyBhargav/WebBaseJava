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

import com.app.dto.ResponceApi;
import com.app.entity.StudentEntity;
import com.app.service.CourseServiceImp;
import com.app.service.StudentServiceImp;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentServiceImp stud;
	@Autowired
	private CourseServiceImp crs;
	
	public StudentController() {
	System.out.println("in Student Ctor");
	}
	@GetMapping
	public ResponseEntity<?> getAllStudent(){
		System.out.println("in get all Student");
		return ResponseEntity.status(HttpStatus.OK).body(stud.getAllStudent());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		System.out.println("In Get by id");
		return ResponseEntity.status(HttpStatus.OK).body(stud.getStudentById(id))	;
	}
	
	@PostMapping
	public ResponseEntity<?> addNewStudent(@RequestBody StudentEntity student) {
		System.out.println("In postmapping");
		return new ResponseEntity<>(stud.addNewStudent(student),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?>updateStudent(@RequestBody StudentEntity student ){
			return new ResponseEntity<>(stud.upDateStudent(student),HttpStatus.OK);	
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		System.out.println("In delete");
		return ResponseEntity.status(HttpStatus.OK).body(stud.deleteStudent(id));
	}
	

	
	
}
