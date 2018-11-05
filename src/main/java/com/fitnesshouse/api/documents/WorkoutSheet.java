package com.fitnesshouse.api.documents;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WorkoutSheet {

	@Id
	private String id;

	private String title;
	private String description;
	private Date dtFinish;
	private Date dtStart;
	private Student student;
	private List<Workout> workouts;

	public WorkoutSheet() {
		super();
	}

	public WorkoutSheet(String id, String title, String description, Date dtFinish, Date dtStart, Student student,
			List<Workout> workouts) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dtFinish = dtFinish;
		this.dtStart = dtStart;
		this.student = student;
		this.workouts = workouts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDtFinish() {
		return dtFinish;
	}

	public void setDtFinish(Date dtFinish) {
		this.dtFinish = dtFinish;
	}

	public Date getDtStart() {
		return dtStart;
	}

	public void setDtStart(Date dtStart) {
		this.dtStart = dtStart;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

}
