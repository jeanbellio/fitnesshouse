package com.fitnesshouse.api.documents;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User implements Serializable {
	
	private static final long serialVersionUID = -4128018351476765756L;
	
	@Id
	private String id;
	private String name;
	private String email;
	private long age;
	private String sex;
	private String password;
	private List<WorkoutSheet> workoutSheet;
	private String idTeacher;
	private List<Message> messages;
	private List<Feedback> feedbacks;
	private String cref;
	private String bio;
	private List<User> students;
	private String type;

	public User() {
		super();
	}

	public User(String id, String name, String email, long age, String sex, String password,
			List<WorkoutSheet> workoutSheet, String idTeacher, List<Message> messages, List<Feedback> feedbacks,
			String cref, String bio, List<User> students, String type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.sex = sex;
		this.password = password;
		this.workoutSheet = workoutSheet;
		this.idTeacher = idTeacher;
		this.messages = messages;
		this.feedbacks = feedbacks;
		this.cref = cref;
		this.bio = bio;
		this.students = students;
		this.type = type;
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

	public List<WorkoutSheet> getWorkoutSheet() {
		return workoutSheet;
	}

	public void setWorkoutSheet(List<WorkoutSheet> workoutSheet) {
		this.workoutSheet = workoutSheet;
	}

	public String getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(String idTeacher) {
		this.idTeacher = idTeacher;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
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

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
