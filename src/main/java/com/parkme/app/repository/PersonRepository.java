package com.parkme.app.repository;

import com.parkme.app.model.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person,Long> {
}
