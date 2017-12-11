package com.mockito.mockitotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockito.mockitotest.entity.Client;
import com.mockito.mockitotest.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
  
  public static final String[] UNWANTED_NICKNAME_CHARACTERS = new String[] {" ", "!", "-", "_"};
  
  @Autowired
  private ClientRepository clientRepo;
  
  public void addClient(Client client) throws Exception {
    if(client == null)
      throw new Exception("Client can't be null");
    if(client.getName() == null || client.getName().equals(""))
      throw new Exception("Client's name must be non null");
    if(!client.getName().equals(client.getName().replaceAll("[*0-9]", "")))
      throw new Exception("Client's name can't contain digits");
    if(client.getNickname() == null || client.getNickname().equals(""))
      throw new Exception("Client's nickname can't be null or empty");
    
    formatClientInformation(client);
    Client temp = getClient(client.getName());
    
    if(temp != null)
      throw new Exception("Client already exists");
    
    clientRepo.save(client);
  }
  
  private void formatClientInformation(Client client) {
    String formatName = client.getName().toLowerCase();
    formatName = formatName.substring(0, 1).toUpperCase() + formatName.substring(1);
    
    String formatNickname = client.getNickname();
    for(String unwantedChar : UNWANTED_NICKNAME_CHARACTERS) {
      formatNickname = client.getNickname().replaceAll(unwantedChar, ".").toUpperCase();      
    }
    
    client.setName(formatName);
    client.setNickname(formatNickname);
  }
  
  public Client getClient(String name) throws Exception {
    if(name == null || name.equals(""))
      throw new Exception("Client's name must be non null");
    Client client = clientRepo.findByName(name);
    return client;
  }

}
