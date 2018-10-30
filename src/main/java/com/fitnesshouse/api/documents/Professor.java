package com.fitnesshouse.api.documents;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Professor {

	@Id
	private String id;

	private String nome;
	private String email;
	private String cref;
	private String biografia;
	private List<Aluno> alunos;
	private Login login;

	public Professor() {
		super();
	}

	public Professor(String id, String nome, String email, String cref, String biografia, List<Aluno> alunos, Login login) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cref = cref;
		this.biografia = biografia;
		this.login = login;
		this.alunos = alunos;
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

	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email inválido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
