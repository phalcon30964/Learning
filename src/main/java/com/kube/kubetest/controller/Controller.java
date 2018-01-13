package com.kube.kubetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kube.kubetest.entity.Client;
import com.kube.kubetest.repository.ClientRepository;

@RestController
public class Controller {

  @Autowired
  private ClientRepository clientRepository;

  @RequestMapping("/client/exists/{name}")
  public String getClient(@PathVariable String name) {
    Client client = clientRepository.findByName(name);
    return (client != null)? "Yes" : "No";
  }
  
  @RequestMapping("/client/insert/{name}")
  public String insertClient(@PathVariable String name) {
    Client client = new Client(name, " hardcoded nickname");
    return clientRepository.save(client).getName();
  }
}
