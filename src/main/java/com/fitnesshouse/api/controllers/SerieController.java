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
import com.fitnesshouse.api.documents.Workout;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.SerieService;
import com.fitnesshouse.api.services.WorkoutService;

@RestController
@RequestMapping(path = "/api/serie")
public class SerieController {

	@Autowired
	private SerieService serieService;
	
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping
	public ResponseEntity<Response<List<Serie>>> findAll(){
		return ResponseEntity.ok(new Response<List<Serie>>(this.serieService.findAll()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Serie>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Serie>(this.serieService.findById(id)));
	}
	
	@GetMapping(path = "/workout/{idWorkout}")
	public ResponseEntity<Response<List<Serie>>> findByIdWorkout(@PathVariable(name = "idWorkout") String idWorkout) {
		return ResponseEntity.ok(new Response<List<Serie>>(this.serieService.findByIdWorkout(idWorkout)));
	}
	
	/*@PostMapping
	public ResponseEntity<Response<Serie>> create(@Valid @RequestBody Serie serie, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Serie>(erros));
		}
		
		return ResponseEntity.ok(new Response<Serie>(this.serieService.create(serie)));
	}*/
	@PostMapping
	public ResponseEntity<Response<Workout>> create(@Valid @RequestBody Serie serie, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Workout>(erros));
		}
		
		Serie serieAux = this.serieService.create(serie);
		Workout workout = this.workoutService.findById(serieAux.getIdWorkout());
		if(workout.getSeries() == null ) {
			workout.setSeries(new ArrayList<Serie>());
		}
		workout.getSeries().add(serieAux);
		return ResponseEntity.ok(new Response<Workout>(this.workoutService.update(workout)));
	}
	
	@PutMapping
	public ResponseEntity<Response<Serie>> update(@Valid @RequestBody Serie serie, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Serie>(erros));
		}
		
		return ResponseEntity.ok(new Response<Serie>(this.serieService.update(serie)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.serieService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
