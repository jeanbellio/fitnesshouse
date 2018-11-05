package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Student;

public interface StudentService {
	List<Student> findAll();
	
	Student findById(String id);
	
	Student create(Student student);
	
	Student update(Student student);
	
	void delete(String id);
}
