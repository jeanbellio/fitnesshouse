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

import com.fitnesshouse.api.documents.User;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{type}")
	public ResponseEntity<Response<List<User>>> findByType(@PathVariable(name = "type") String type){
		return ResponseEntity.ok(new Response<List<User>>(this.userService.findByType(type)));
	}
	
	@GetMapping(path = "/student")
	public ResponseEntity<Response<List<User>>> findStudentWithoutTeacher(){
		return ResponseEntity.ok(new Response<List<User>>(this.userService.findStudentWithoutTeacher()));
	}
	
	/*@GetMapping
	public ResponseEntity<Response<List<User>>> findAllByType(@PathVariable(name = "type") String type){
		return ResponseEntity.ok(new Response<List<User>>(this.userService.findAll()));
	}*/
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Response<User>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<User>(this.userService.findById(id)));
	}
	
	@GetMapping(path = "/{name}/{type}")
	public ResponseEntity<Response<List<User>>> findByNameAndType(@PathVariable("name") String name, @PathVariable("type") String type) {
		return ResponseEntity.ok(new Response<List<User>>(this.userService.findByNameAndType(name, type)));
	}
	
	@PostMapping
	public ResponseEntity<Response<User>> create(@Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<User>(erros));
		}
		
		return ResponseEntity.ok(new Response<User>(this.userService.create(user)));
	}
	
	@PutMapping
	public ResponseEntity<Response<User>> update(@Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<User>(erros));
		}
		
		return ResponseEntity.ok(new Response<User>(this.userService.update(user)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.userService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<Response<User>> login(@Valid @RequestBody User user) {
		User userAux = this.userService.findByEmail(user.getEmail());
		if(userAux != null && userAux.getPassword() != null && userAux.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok(new Response<User>(userAux));
		}else {
			List<String> erros = new ArrayList<String>();
			erros.add("login invalido");
			return ResponseEntity.badRequest().body(new Response<User>(erros));
		}
	}
	
	//@PostMapping(path = "/{idTeacher}/{idStudent}")
	//public ResponseEntity<Response<User>> addStudentToTeacher(@PathVariable("idTeacher") String idTeacher,
	//@PathVariable("idStudent") String idStudent) {

	@PostMapping(path = "/addStudentToTeacher/{idTeacher}/{idStudent}")
	public ResponseEntity<Response<User>> addStudenToTeacher(@PathVariable(name = "idTeacher") String idTeacher, 
															 @PathVariable(name = "idStudent") String idStudent){
		
		List<String> erros = new ArrayList<String>();
				
		try {
			if (idTeacher != null && idStudent != null) {
				User student = new User();
				User teacher = new User();

				student = this.userService.findById(idStudent);
				if (student != null) {
					teacher = this.userService.findById(idTeacher);
					if (teacher != null) {
						student.setIdTeacher(idTeacher);
						this.userService.update(student);
						teacher.getStudents().add(student);
						return ResponseEntity.ok(new Response<User>(userService.update(teacher)));
					} else {
						erros.add("invalid idTeacher");
					}
				} else {
					erros.add("invalid idStudent");
				}

			}
			erros.add("null parameters");
		} catch (Exception e) {
			erros.add(e.getMessage());
		}
		
		return ResponseEntity.badRequest().body(new Response<User>(erros));
	}
	
}
