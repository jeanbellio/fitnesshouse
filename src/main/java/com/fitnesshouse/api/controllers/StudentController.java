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

import com.fitnesshouse.api.documents.Student;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.StudentService;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<Response<List<Student>>> findAll(){
		return ResponseEntity.ok(new Response<List<Student>>(this.studentService.findAll()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Student>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Student>(this.studentService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Student>> create(@Valid @RequestBody Student student, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Student>(erros));
		}
		
		return ResponseEntity.ok(new Response<Student>(this.studentService.create(student)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Student>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Student student, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Student>(erros));
		}
		
		student.setId(id);
		return ResponseEntity.ok(new Response<Student>(this.studentService.update(student)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.studentService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
