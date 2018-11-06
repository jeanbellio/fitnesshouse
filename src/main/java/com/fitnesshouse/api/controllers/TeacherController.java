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
import com.fitnesshouse.api.documents.Teacher;
import com.fitnesshouse.api.response.Response;
import com.fitnesshouse.api.services.StudentService;
import com.fitnesshouse.api.services.TeacherService;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<Response<List<Teacher>>> findAll() {
		return ResponseEntity.ok(new Response<List<Teacher>>(this.teacherService.findAll()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Teacher>> findById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Teacher>(this.teacherService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<Response<Teacher>> create(@Valid @RequestBody Teacher teacher, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Teacher>(erros));
		}

		return ResponseEntity.ok(new Response<Teacher>(this.teacherService.create(teacher)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Teacher>> update(@PathVariable(name = "id") String id,
			@Valid @RequestBody Teacher teacher, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Teacher>(erros));
		}

		teacher.setId(id);
		return ResponseEntity.ok(new Response<Teacher>(this.teacherService.update(teacher)));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.teacherService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

	@PostMapping(path = "/addStudent/idTeacher/{idTeacher}/idStudent/{idStudent}")
	public ResponseEntity<Response<Teacher>> addStudenToTeacher(@PathVariable("idTeacher") String idTeacher,
																@PathVariable("idStudent") String idStudent) {
		
		List<String> erros = new ArrayList<String>();
		
		try {
			if (idTeacher != null && idStudent != null) {
				Student student = new Student();
				Teacher teacher = new Teacher();

				student = this.studentService.findById(idStudent);
				if (student != null) {
					teacher = this.teacherService.findById(idTeacher);
					if (teacher != null) {
						student.setIdTeacher(idTeacher);
						this.studentService.update(student);
						teacher.getStudents().add(student);
						return ResponseEntity.ok(new Response<Teacher>(this.teacherService.update(teacher)));
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
		
		return ResponseEntity.badRequest().body(new Response<Teacher>(erros));
	}

}
