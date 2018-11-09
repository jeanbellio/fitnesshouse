package com.fitnesshouse.api.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fitnesshouse.api.enums.MuscleGroupEnum;

@Document
public class Exercise {

	@Id
	private String id;

	private String title;
	private String description;
	private MuscleGroupEnum muscleGroup;
	private String image;
	private String repetitions;
	private String series;
	private String weight;
	private int sprints;
	private String time;
	private String rest;
	private String comments;
	private boolean selected;

	public Exercise() {
		super();
	}

	public Exercise(String id, String title, MuscleGroupEnum muscleGroup, String description, String image, String repetitions, String series,
			String weight, int sprints, String time, String rest, String comments, boolean selected) {
		super();
		this.id = id;
		this.title = title;
		this.muscleGroup = muscleGroup;
		this.description = description;
		this.image = image;
		this.repetitions = repetitions;
		this.series = series;
		this.weight = weight;
		this.sprints = sprints;
		this.time = time;
		this.rest = rest;
		this.comments = comments;
		this.selected = selected;
	}
	
	public Exercise(String title, String description, MuscleGroupEnum muscleGroup) {
		super();
		this.title = title;
		this.description = description;
		this.muscleGroup = muscleGroup;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Título não pode ser vazio")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotEmpty(message = "Descrição não pode ser vazia")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public MuscleGroupEnum getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(MuscleGroupEnum muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(String repetitions) {
		this.repetitions = repetitions;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
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

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
