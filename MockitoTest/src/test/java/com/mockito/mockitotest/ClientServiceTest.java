package com.mockito.mockitotest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mockito.mockitotest.entity.Client;
import com.mockito.mockitotest.repository.ClientRepository;
import com.mockito.mockitotest.service.ClientService;
import com.mockito.mockitotest.service.ClientServiceImpl;

public class ClientServiceTest {
  
  @InjectMocks
  private ClientService clientService = new ClientServiceImpl();
  @Mock
  private ClientRepository repository;
  
  private Client testClient1;
  
  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
    testClient1 = new Client("Testname", "TestNickname");
    Mockito.when(repository.findByName(testClient1.getName())).thenReturn(testClient1);
  }

  @Test
  public void getClientCorrectly() throws Exception {
    Client client = clientService.getClient(testClient1.getName());
    assertThat(client).isNotEqualTo(null);
    assertThat(client.getName()).isEqualTo(testClient1.getName());
  }
  
  @Test
  public void getClientCorrectlyNullResponse() throws Exception {
    Client client = clientService.getClient("NonExistingName");
    assertThat(client).isEqualTo(null);
  }
  
  @Test(expected=Exception.class)
  public void getClientWithEmtpyString() throws Exception {
    clientService.getClient("");
  }
  
  @Test(expected=Exception.class)
  public void getClientWithNullString() throws Exception {
    clientService.getClient(null);
  }
  
  @Test(expected=Exception.class)
  public void addClientAlreadyExistingClient() throws Exception {
    clientService.addClient(testClient1);
  }
}
