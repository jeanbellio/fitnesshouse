package com.fitnesshouse.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnesshouse.api.documents.Exercise;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.ExerciseService;

@RestController
@RequestMapping(path = "/api/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;

//	@GetMapping(path = "/{name}/{muscleGroup}")
//	public ResponseEntity<Response<List<Exercise>>> findByNameAndMuscleGroup(@PathVariable(name = "name") String name, @PathVariable String muscleGroup) {
//		return ResponseEntity.ok(new Response<List<Exercise>>(this.exerciseService.findByNameAndMuscleGroupName(name, muscleGroup)));
//	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(path = "/{name}")
	public ResponseEntity<Response<List<Exercise>>> findByTitle(@PathVariable(name = "name") String name) {
		return ResponseEntity.ok(new Response<List<Exercise>>(this.exerciseService.findByTitle(name)));
	}
	
	/**
	 * Método responsável por capturar o endpoint /api/student/ (post) e criar um novo exercício. JSON exemplo:
	 * {"title" : "Supino reto", "description" : "Deitado sob a barra..."}
	 */
	@PostMapping
	public ResponseEntity<Response<Exercise>> create(@Valid @RequestBody Exercise exercise, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Exercise>(erros));
		}
		
		return ResponseEntity.ok(new Response<Exercise>(this.exerciseService.create(exercise)));
	}
	

}
