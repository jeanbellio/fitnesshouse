package com.fitnesshouse.api.documents;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fitnesshouse.api.enums.MuscleGroupEnum;

@Document
public class Workout {

	@Id
	private String id;

	private String nameWorkout;
	private MuscleGroupEnum workoutIdentifier;
	private List<Exercise> exercises;

	public Workout() {
		super();
	}

	public Workout(String id, String nameWorkout, MuscleGroupEnum workoutIdentifier, List<Exercise> exercises) {
		super();
		this.id = id;
		this.nameWorkout = nameWorkout;
		this.workoutIdentifier = workoutIdentifier;
		this.exercises = exercises;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome do treino não pode ser vazio")
	public String getNameWorkout() {
		return nameWorkout;
	}

	public void setNameWorkout(String nameWorkout) {
		this.nameWorkout = nameWorkout;
	}

	public MuscleGroupEnum getWorkoutIdentifier() {
		return workoutIdentifier;
	}

	public void setWorkoutIdentifier(MuscleGroupEnum workoutIdentifier) {
		this.workoutIdentifier = workoutIdentifier;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

}
