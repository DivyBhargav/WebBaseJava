package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.entity.CourseEntity;
import com.app.entity.StudentEntity;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;
@Service
@Transactional
public class StudentServiceImp implements StudentService {
	
@Autowired
private StudentRepository studrepo;
@Autowired
private CourseRepository courrepo;

	@Override
	public StudentEntity addNewStudent(StudentEntity student) {
		
		CourseEntity cr = courrepo.findById(student.getCourse().getId())
				.orElseThrow(()->new CustomException("Invalid course"));
		if(student.getScore()<cr.getMinScore())
			throw new CustomException("Sorry Got less Marks");
		else
			return studrepo.save(student);	
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		return studrepo.findAll();
	}

	@Override
	public StudentEntity getStudentById(Long id) {
		return studrepo.findById(id).orElseThrow(()->new CustomException("Invalid Student Id"));
	}

	@Override
	public StudentEntity upDateStudent(StudentEntity st) {
		CourseEntity cr = courrepo.findById(st.getCourse().getId())
				.orElseThrow(()->new CustomException("Invalid course"));
		if(st.getScore()<cr.getMinScore())
			throw new CustomException("Sorry Got less Marks");
		else
			return studrepo.save(st);	
		
	}

	@Override
	public String deleteStudent(Long Id) {
		String msg = "Can not Delet";
		if(studrepo.existsById(Id)) {
			studrepo.deleteById(Id);
		msg="Delete successfully";
		}
		return msg;
	}

}
