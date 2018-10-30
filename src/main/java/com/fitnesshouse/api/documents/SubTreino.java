package com.fitnesshouse.api.documents;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SubTreino {

	@Id
	private String id;

	private String nome;
	private long intensidade;
	private List<Exercicio> exercicios;
	private List<Date> datasRealizadas;

	public SubTreino() {
		super();
	}

	public SubTreino(String id, String nome, long intensidade, List<Exercicio> exercicios,
			List<Date> datasRealizadas) {
		super();
		this.id = id;
		this.nome = nome;
		this.intensidade = intensidade;
		this.exercicios = exercicios;
		this.datasRealizadas = datasRealizadas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome não pode ser vazio")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(long intensidade) {
		this.intensidade = intensidade;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public List<Date> getDatasRealizadas() {
		return datasRealizadas;
	}

	public void setDatasRealizadas(List<Date> datasRealizadas) {
		this.datasRealizadas = datasRealizadas;
	}

}
