package com.fitnesshouse.api.documents;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WorkoutSheet implements Serializable {

	private static final long serialVersionUID = 8787898698787613739L;

	@Id
	private String id;

	private String title;
	private String description;
	private Date dtFinish;
	private Date dtStart;
	private String idStudent;
	private List<Workout> workouts;
	private String idTeacher;

	public WorkoutSheet() {
		super();
	}

	public WorkoutSheet(String id, String title, String description, Date dtFinish, Date dtStart, String idStudent,
			List<Workout> workouts, String idTeacher) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dtFinish = dtFinish;
		this.dtStart = dtStart;
		this.idStudent = idStudent;
		this.workouts = workouts;
		this.idTeacher = idTeacher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//@NotEmpty(message = "Título da ficha de treino não pode ser vazio")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//@NotEmpty(message = "Descrição da ficha de treino não pode ser vazio")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public String getDtFinish() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(dtFinish);
		return strDate;
	}*/
	
	public Date getDtFinish() {
		return dtFinish;
	}

	public void setDtFinish(Date dtFinish) {
		this.dtFinish = dtFinish;
	}

	/*public String getDtStart() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(dtStart);
        return strDate;
	}*/
	public Date getDtStart() {
		return dtStart;
	}
	
	public void setDtStart(Date dtStart) {
		this.dtStart = dtStart;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public String getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(String idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	

}
