package com.fitnesshouse.api.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Exercicio {

	@Id
	private String id;
	
	private String nome;
	private String descricao;
	private String foto;
	private String tipo;
	private String observacao;
	private List<Serie> series;
	
	public Exercicio() {
		super();
	}

	public Exercicio(String id, String nome, String descricao, String foto, String tipo, String observacao,
			List<Serie> series) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.foto = foto;
		this.tipo = tipo;
		this.observacao = observacao;
		this.series = series;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	
}
