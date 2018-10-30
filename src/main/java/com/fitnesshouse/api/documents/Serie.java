package com.fitnesshouse.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Serie {
	
	@Id
	private String id;
	private double carga;
	private long repeticoes;
	private long qtdSeries;
	
	public Serie(String id, double carga, long repeticoes, long qtdSeries) {
		super();
		this.id = id;
		this.carga = carga;
		this.repeticoes = repeticoes;
		this.qtdSeries = qtdSeries;
	}

	public Serie() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public long getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(long repeticoes) {
		this.repeticoes = repeticoes;
	}

	public long getQtdSeries() {
		return qtdSeries;
	}

	public void setQtdSeries(long qtdSeries) {
		this.qtdSeries = qtdSeries;
	}
	
	
}
