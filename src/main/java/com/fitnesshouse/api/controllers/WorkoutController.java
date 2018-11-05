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

import com.fitnesshouse.api.documents.Workout;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.WorkoutService;

@RestController
@RequestMapping(path = "/api/workout")
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping
	public ResponseEntity<Response<List<Workout>>> findAll(){
		return ResponseEntity.ok(new Response<List<Workout>>(this.workoutService.findAll()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Workout>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Workout>> create(@Valid @RequestBody Workout workout, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Workout>(erros));
		}
		
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.create(workout)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Workout>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Workout workout, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Workout>(erros));
		}
		
		workout.setId(id);
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.update(workout)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.workoutService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
