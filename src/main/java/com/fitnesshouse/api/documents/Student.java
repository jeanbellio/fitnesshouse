package com.fitnesshouse.api.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student extends User {

	private List<WorkoutSheet> workoutSheet;
	private Teacher teacher;
	private List<Message> messages;
	private List<Feedback> feedbacks;

	public Student() {
		super();
	}

	public Student(List<WorkoutSheet> workoutSheet, Teacher teacher, List<Message> messages,
			List<Feedback> feedbacks) {
		super();
		this.workoutSheet = workoutSheet;
		this.teacher = teacher;
		this.messages = messages;
		this.feedbacks = feedbacks;
	}

	public List<WorkoutSheet> getWorkoutSheet() {
		return workoutSheet;
	}

	public void setWorkoutSheet(List<WorkoutSheet> workoutSheet) {
		this.workoutSheet = workoutSheet;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	
}
