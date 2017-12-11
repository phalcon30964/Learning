package com.mockito.mockitotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.mockitotest.entity.Client;
import com.mockito.mockitotest.service.ClientService;

@RestController
public class ClientController {

  @Autowired
  private ClientService clientService;
  
  @RequestMapping("/client/insert/{name}/{nickname}")
  public String getClient(@PathVariable String name, @PathVariable String nickname) {
    try {
      Client client = new Client(name, nickname);
      clientService.addClient(client);
      return "Client " + client.getName() + " created";
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
