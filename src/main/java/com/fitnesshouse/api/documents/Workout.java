package com.fitnesshouse.api.documents;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fitnesshouse.api.enums.MuscleGroupEnum;

@Document
public class Workout implements Serializable {

	private static final long serialVersionUID = -6872816870436638379L;

	@Id
	private String id;

	private String nameWorkout;
	private MuscleGroupEnum workoutIdentifier;
	private List<Serie> series;
	private String idWorkoutSheet;

	public Workout() {
		super();
	}

	public Workout(String id, String nameWorkout, MuscleGroupEnum workoutIdentifier, List<Serie> series, String idWorkoutSheet) {
		super();
		this.id = id;
		this.nameWorkout = nameWorkout;
		this.workoutIdentifier = workoutIdentifier;
		this.series = series;
		this.idWorkoutSheet = idWorkoutSheet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//@NotEmpty(message = "Nome do treino não pode ser vazio")
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

	public List<Serie> getSeries() {
		return series;
	}

	public void setSerie(List<Serie> series) {
		this.series = series;
	}

	public String getIdWorkoutSheet() {
		return idWorkoutSheet;
	}

	public void setIdWorkoutSheet(String idWorkoutSheet) {
		this.idWorkoutSheet = idWorkoutSheet;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	

}
