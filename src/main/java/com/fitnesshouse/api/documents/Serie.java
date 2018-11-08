package com.fitnesshouse.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Serie {
	
	@Id
	private String id;
	
	private String weight;
	private int sprints;
	private String time;
	private long repetitions;
	private Student student;
	private Exercise exercise;
	private Workout workout;
	
	public Serie() {
		super();
	}

	public Serie(String id, String weight, int sprints, String time, long repetitions, Student student, Exercise exercise,
			Workout workout) {
		super();
		this.id = id;
		this.weight = weight;
		this.sprints = sprints;
		this.time = time;
		this.repetitions = repetitions;
		this.student = student;
		this.exercise = exercise;
		this.workout = workout;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getSprints() {
		return sprints;
	}

	public void setSprints(int sprints) {
		this.sprints = sprints;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public long getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(long repetitions) {
		this.repetitions = repetitions;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	
}
