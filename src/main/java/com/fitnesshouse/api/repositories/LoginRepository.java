package com.fitnesshouse.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<LoginRepository, String> {

}
