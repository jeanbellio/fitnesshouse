package com.fitnesshouse.api.services;

import java.util.List;

import com.fitnesshouse.api.documents.Teacher;

public interface TeacherService {
	
	List<Teacher> findAll();
	
	Teacher findById(String id);
	
	Teacher create(Teacher teacher);
	
	Teacher update(Teacher teacher);
	
	void delete(String id);
	
	List<Teacher> findByName(String name);
}
