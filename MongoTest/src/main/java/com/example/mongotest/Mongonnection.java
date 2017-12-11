package com.example.mongotest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Mongonnection extends MongoRepository<ElementA, String> {

}
