package com.kube.kubetest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kube.kubetest.entity.Client;

public interface ClientRepository extends MongoRepository<Client, String>{
  
  public Client findByName(String name);
  
}
