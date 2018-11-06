package com.fitnesshouse.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fitnesshouse.api.documents.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String> {

	@Query("{ 'name' : { '$regex' : ?0}}")
	List<Teacher> findByName(String name);
	
}
