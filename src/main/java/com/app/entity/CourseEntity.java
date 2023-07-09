package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name= "new_course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseEntity extends BaseEntity{

	@Column(length = 30)
	private String name;
	@Column
	private LocalDate stratingDate;
	@Column
	private LocalDate endDate;
	@Column
	private double fee;
	@Column
	private int minScore;
	@OneToMany(mappedBy = "course",cascade =CascadeType.ALL,orphanRemoval = true )
	@JsonIgnore
	private List<StudentEntity>student = new ArrayList<>();
}
