package com.fitnesshouse.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {
	
	@Id
	private String id;

	private Professor professor;
	private String descricao;
	private Aluno aluno;
	private boolean anonimo;
	
	public Feedback(String id, Professor professor, String descricao, Aluno aluno, boolean anonimo) {
		super();
		this.id = id;
		this.professor = professor;
		this.descricao = descricao;
		this.aluno = aluno;
		this.anonimo = anonimo;
	}

	public Feedback() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}
	
	
}
