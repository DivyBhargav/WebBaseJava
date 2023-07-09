package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
