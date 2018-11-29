package com.fitnesshouse.api.documents;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fitnesshouse.api.enums.MuscleGroupEnum;

@Document
public class Exercise implements Serializable {

	private static final long serialVersionUID = -5382808141406832577L;

	@Id
	private String id;

	private String title;
	private String description;
	private MuscleGroupEnum muscleGroup;
	private String image;

	public Exercise() {
		super();
	}

	public Exercise(String id, String title, String description, MuscleGroupEnum muscleGroup, String image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.muscleGroup = muscleGroup;
		this.image = image;
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

}
