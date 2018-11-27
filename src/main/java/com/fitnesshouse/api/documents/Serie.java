package com.fitnesshouse.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Serie {

	@Id
	private String id;

	private String observation;
	private String weight;
	private int sprints;
	private String time;
	private long repetitions;
	private Exercise exercise;
	private String idWorkout;
	private String rest;
	private long quantity;

	public Serie() {
		super();
	}

	public Serie(String id, String observation, String weight, int sprints, String time, long repetitions,
			Exercise exercise, String idWorkout, String rest, long quantity) {
		super();
		this.id = id;
		this.observation = observation;
		this.weight = weight;
		this.sprints = sprints;
		this.time = time;
		this.repetitions = repetitions;
		this.exercise = exercise;
		this.idWorkout = idWorkout;
		this.rest = rest;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
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

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public String getIdWorkout() {
		return idWorkout;
	}

	public void setIdWorkout(String idWorkout) {
		this.idWorkout = idWorkout;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
