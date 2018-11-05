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

import com.fitnesshouse.api.documents.WorkoutSheet;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.WorkoutSheetService;

@RestController
@RequestMapping(path = "/api/workoutSheet")
public class WorkoutSheetController {

	@Autowired
	private WorkoutSheetService workoutSheetService;
	
	@GetMapping
	public ResponseEntity<Response<List<WorkoutSheet>>> findAll(){
		return ResponseEntity.ok(new Response<List<WorkoutSheet>>(this.workoutSheetService.findAll()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<WorkoutSheet>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<WorkoutSheet>(this.workoutSheetService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<WorkoutSheet>> create(@Valid @RequestBody WorkoutSheet workoutSheet, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<WorkoutSheet>(erros));
		}
		
		return ResponseEntity.ok(new Response<WorkoutSheet>(this.workoutSheetService.create(workoutSheet)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<WorkoutSheet>> update(@PathVariable(name = "id") String id, @Valid @RequestBody WorkoutSheet workoutSheet, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<WorkoutSheet>(erros));
		}
		
		workoutSheet.setId(id);
		return ResponseEntity.ok(new Response<WorkoutSheet>(this.workoutSheetService.update(workoutSheet)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.workoutSheetService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
