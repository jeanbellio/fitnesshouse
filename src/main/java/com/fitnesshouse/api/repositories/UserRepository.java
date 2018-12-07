package com.fitnesshouse.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fitnesshouse.api.documents.User;

public interface UserRepository extends MongoRepository<User, String> {

	//@Query("{ 'name' : { '$regex' : ?0}, 'type' : { '$regex' : ?0}}")
	List<User> findByTypeIgnoreCaseAndNameLikeIgnoreCase(String type, String name);
	
	@Query(value = "{ $and: [ { 'email' : ?0 } , { 'password' : ?0 } ] }")
	User login(String email, String password);
	
	//@Query(value = "{ 'email' : ?0 }")
	User findByEmailIgnoreCase(String email);
	
	List<User> findByTypeIgnoreCase(String type);
	
	List<User> findByTypeAndIdTeacherIsNull(String type);

	List<User> findByTypeIgnoreCaseAndNameLikeIgnoreCaseAndIdTeacherIsNull(String type, String name);

}
