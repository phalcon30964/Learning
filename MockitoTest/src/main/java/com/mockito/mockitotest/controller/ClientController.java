package com.mockito.mockitotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.mockitotest.entity.Client;
import com.mockito.mockitotest.service.ClientService;

@RestController
public class ClientController {

  @Autowired
  private ClientService clientService;
  
  @RequestMapping("/client/insert")
  public String addClient(@RequestParam("name") String name, @RequestParam("nickname") String nickname) {
    try {
      Client client = new Client(name, nickname);
      clientService.addClient(client);
      return client.toString() + " created";
    } catch (Exception e) {
      return e.getMessage();
    }
  }
  
  @RequestMapping("/client/get")
  public String getClient(@RequestParam("name") String name) {
    try {
      Client client = clientService.getClient(name);
      return (client != null)? client.toString() : "Client doesn't exist";
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
