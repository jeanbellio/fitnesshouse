package com.fitnesshouse.api.documents;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message implements Serializable {

	private static final long serialVersionUID = -3894974653942339993L;

	@Id
	private String id;

	private User student;
	private Teacher teacher;
	private String message;
	private Date dtMessage;

	public Message() {
		super();
	}

	public Message(String id, User student, Teacher teacher, String message, Date dtMessage) {
		super();
		this.id = id;
		this.student = student;
		this.teacher = teacher;
		this.message = message;
		this.dtMessage = dtMessage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return student;
	}

	public void setUser(User student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@NotEmpty(message = "Mensagem não pode ser vazio")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDtMessage() {
		return dtMessage;
	}

	public void setDtMessage(Date dtMessage) {
		this.dtMessage = dtMessage;
	}

}
