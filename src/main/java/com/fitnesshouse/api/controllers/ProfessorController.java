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

import com.fitnesshouse.api.documents.Professor;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.ProfessorService;

@RestController
@RequestMapping(path = "/api/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public ResponseEntity<Response<List<Professor>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Professor>>(this.professorService.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Professor>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Professor>(this.professorService.listarPorId(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Professor>> cadastrar(@Valid @RequestBody Professor professor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Professor>(erros));
		}
		
		return ResponseEntity.ok(new Response<Professor>(this.professorService.cadastrar(professor)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Professor>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Professor professor, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Professor>(erros));
		}
		
		professor.setId(id);
		return ResponseEntity.ok(new Response<Professor>(this.professorService.atualizar(professor)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.professorService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
