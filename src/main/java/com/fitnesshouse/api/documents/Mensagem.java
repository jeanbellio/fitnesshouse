package com.fitnesshouse.api.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Mensagem {

	@Id
	private String id;
	
	private Aluno aluno;
	private Professor professor;
	private String mensagem;
	private Date dtMensagem;
	
	public Mensagem() {
		super();
	}

	public Mensagem(String id, Aluno aluno, Professor professor, String mensagem, Date dtMensagem) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.professor = professor;
		this.mensagem = mensagem;
		this.dtMensagem = dtMensagem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getDtMensagem() {
		return dtMensagem;
	}

	public void setDtMensagem(Date dtMensagem) {
		this.dtMensagem = dtMensagem;
	}
	
	
}
