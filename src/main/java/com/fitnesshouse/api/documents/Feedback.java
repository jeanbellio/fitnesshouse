package com.fitnesshouse.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {
	
	@Id
	private String id;

	private Teacher teacher;
	private String description;
	private Student student;
	private boolean anonimo;
	
	public Feedback() {
		super();
	}

	public Feedback(String id, Teacher teacher, String description, Student student, boolean anonimo) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.description = description;
		this.student = student;
		this.anonimo = anonimo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}
	
}
