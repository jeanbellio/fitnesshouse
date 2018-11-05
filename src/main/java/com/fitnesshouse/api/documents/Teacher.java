package com.fitnesshouse.api.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Teacher extends User{

	private String cref;
	private String bio;
	private List<Student> students;

	public Teacher() {
		super();
	}

	public Teacher(String cref, String bio, List<Student> students) {
		super();
		this.cref = cref;
		this.bio = bio;
		this.students = students;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

		
}
