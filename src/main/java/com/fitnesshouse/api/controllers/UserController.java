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

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Response<List<User>>> findAllByType(@PathVariable(name = "type") String type){
		return ResponseEntity.ok(new Response<List<User>>(this.userService.findAll()));
	}
	
	/*@GetMapping
	public ResponseEntity<Response<List<User>>> findAllByType(@PathVariable(name = "type") String type){
		return ResponseEntity.ok(new Response<List<User>>(this.userService.findAll()));
	}*/
	
	/*@GetMapping(path = "/{id}")
	public ResponseEntity<Response<User>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<User>(this.userService.findById(id)));
	}*/
	
	@GetMapping(path = "/{name}/{type}")
	public ResponseEntity<Response<List<User>>> findByName(@PathVariable("name") String name, @PathVariable("type") String type) {
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
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<User>> update(@PathVariable(name = "id") String id, @Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<User>(erros));
		}
		
		user.setId(id);
		return ResponseEntity.ok(new Response<User>(this.userService.update(user)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.userService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<Response> login(@Valid @RequestBody User user) {
		User userAux = this.userService.findByEmail(user);
		if(userAux != null && userAux.getPassword() != null && userAux.getPassword().equals(user.getPassword())) {
			return ResponseEntity.ok(new Response<User>(userAux));
		}else {
			List<String> erros = new ArrayList<String>();
			erros.add("login invalido");
			return ResponseEntity.badRequest().body(new Response<User>(erros));
		}
	}
}
