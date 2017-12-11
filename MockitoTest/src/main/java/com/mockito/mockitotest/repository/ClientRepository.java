package com.mockito.mockitotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mockito.mockitotest.entity.Client;


public interface ClientRepository extends MongoRepository<Client, String>{
  
  public Client findByName(String name);
  
}
