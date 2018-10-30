package com.fitnesshouse.api.documents;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Treino {

	@Id
	private String id;

	private String objetivo;
	private Date dataFimPrevisto;
	private long qtdRepeticoes;
	private Professor professor;
	private List<SubTreino> subtreinos;

	public Treino() {
		super();
	}

	public Treino(String id, String objetivo, Date dataFimPrevisto, long qtdRepeticoes, Professor professor,
			List<SubTreino> subtreinos) {
		super();
		this.id = id;
		this.objetivo = objetivo;
		this.dataFimPrevisto = dataFimPrevisto;
		this.qtdRepeticoes = qtdRepeticoes;
		this.professor = professor;
		this.subtreinos = subtreinos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Objetivo não pode ser vazio")
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getDataFimPrevisto() {
		return dataFimPrevisto;
	}

	public void setDataFimPrevisto(Date dataFimPrevisto) {
		this.dataFimPrevisto = dataFimPrevisto;
	}

	public long getQtdRepeticoes() {
		return qtdRepeticoes;
	}

	public void setQtdRepeticoes(long qtdRepeticoes) {
		this.qtdRepeticoes = qtdRepeticoes;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<SubTreino> getSubtreinos() {
		return subtreinos;
	}

	public void setSubtreinos(List<SubTreino> subtreinos) {
		this.subtreinos = subtreinos;
	}

}
