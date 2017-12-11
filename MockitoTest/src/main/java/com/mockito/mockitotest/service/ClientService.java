package com.mockito.mockitotest.service;

import com.mockito.mockitotest.entity.Client;

public interface ClientService {
  
  void addClient(Client client) throws Exception;
  Client getClient(String name) throws Exception;

}
