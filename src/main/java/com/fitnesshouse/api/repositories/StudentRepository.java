package com.fitnesshouse.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fitnesshouse.api.documents.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	@Query("{ 'name' : { '$regex' : ?0}}")
	List<Student> findByName(String name);

}
