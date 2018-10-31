package com.fitnesshouse.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnesshouse.api.documents.Aluno;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.AlunoService;

@RestController
@RequestMapping(path = "/api/treinos")
public class TreinoController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<Response<List<Aluno>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Aluno>>(this.alunoService.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Aluno>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Aluno>(this.alunoService.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Aluno>> cadastrar(@Valid @RequestBody Aluno aluno, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Aluno>(erros));
		}
		
		return ResponseEntity.ok(new Response<Aluno>(this.alunoService.cadastrar(aluno)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Aluno>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Aluno aluno, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Aluno>(erros));
		}
		
		aluno.setId(id);
		return ResponseEntity.ok(new Response<Aluno>(this.alunoService.atualizar(aluno)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.alunoService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
