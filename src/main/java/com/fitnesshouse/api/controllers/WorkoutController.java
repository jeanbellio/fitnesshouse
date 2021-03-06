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

import com.fitnesshouse.api.documents.Serie;
import com.fitnesshouse.api.documents.User;
import com.fitnesshouse.api.documents.Workout;
import com.fitnesshouse.api.documents.WorkoutSheet;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.WorkoutService;
import com.fitnesshouse.api.services.WorkoutSheetService;

@RestController
@RequestMapping(path = "/api/workout")
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private WorkoutSheetService workoutSheetService;
	
	@GetMapping
	public ResponseEntity<Response<List<Workout>>> findAll(){
		return ResponseEntity.ok(new Response<List<Workout>>(this.workoutService.findAll()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Workout>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.findById(id)));
	}
	
	@GetMapping(path = "/workoutSheet/{idWorkoutSheet}")
	public ResponseEntity<Response<List<Workout>>> findByIdWorkoutSheet(@PathVariable(name = "idWorkoutSheet") String idWorkoutSheet) {
		return ResponseEntity.ok(new Response<List<Workout>>(this.workoutService.findByIdWorkoutSheet(idWorkoutSheet)));
	}
	
	/*@PostMapping
	public ResponseEntity<Response<Workout>> create(@Valid @RequestBody Workout workout, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Workout>(erros));
		}
		
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.create(workout)));
	}*/
	@PostMapping
	public ResponseEntity<Response<WorkoutSheet>> create(@Valid @RequestBody Workout workout, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<WorkoutSheet>(erros));
		}
		Workout workoutAux = this.workoutService.create(workout);
		WorkoutSheet workoutSheet = this.workoutSheetService.findById(workoutAux.getIdWorkoutSheet());
		if(workoutSheet.getWorkouts() == null ) {
			workoutSheet.setWorkouts(new ArrayList<Workout>());
		}
		workoutSheet.getWorkouts().add(workoutAux);
		return ResponseEntity.ok(new Response<WorkoutSheet>(this.workoutSheetService.update(workoutSheet)));
	}
	
	@PutMapping
	public ResponseEntity<Response<Workout>> update(@Valid @RequestBody Workout workout, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Workout>(erros));
		}
		
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.update(workout)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.workoutService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
