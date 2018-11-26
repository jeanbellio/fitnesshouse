package com.fitnesshouse.api.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Teacher {

	@Id
	private String id;
	private String name;
	private String email;
	private long age;
	private String sex;
	private String password;
	private String cref;
	private String bio;
	private List<User> students;

	public Teacher() {
		super();
	}

	public Teacher(String name, String email, long age, String sex, String password, String cref, String bio,
			List<User> students) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.sex = sex;
		this.password = password;
		this.cref = cref;
		this.bio = bio;
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<User> getUsers() {
		return students;
	}

	public void setUsers(List<User> students) {
		this.students = students;
	}

}
