package com.app.service;

import java.util.List;

import com.app.entity.StudentEntity;

public interface StudentService {
	
	public StudentEntity addNewStudent(StudentEntity student);
	
	public List<StudentEntity> getAllStudent();
	
	public StudentEntity getStudentById(Long id);
	
	public StudentEntity upDateStudent(StudentEntity st);
	
	public String deleteStudent(Long Id);
	
	

}
