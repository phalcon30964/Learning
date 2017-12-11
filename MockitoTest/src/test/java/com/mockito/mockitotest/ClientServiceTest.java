package com.mockito.mockitotest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mockito.mockitotest.entity.Client;
import com.mockito.mockitotest.repository.ClientRepository;
import com.mockito.mockitotest.service.ClientService;
import com.mockito.mockitotest.service.ClientServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {
  
  @InjectMocks
  private ClientService clientService = new ClientServiceImpl();
  @Mock
  private ClientRepository repository;
  
  private Client testClient1;
  
  @Before
  public void setupMock() {
    MockitoAnnotations.initMocks(this);
    
    testClient1 = new Client("TestName", "TestNickname");
    Mockito.when(repository.findByName(testClient1.getName())).thenReturn(testClient1);
  }

  @Test(expected=Exception.class)
  public void getClientWithEmtpyString() throws Exception {
    clientService.getClient("");
  }
  
  @Test(expected=Exception.class)
  public void getClientWithNullString() throws Exception {
    clientService.getClient(null);
  }
  
  @Test
  public void getClientWithCorrectly() throws Exception {
    Client client = clientService.getClient(testClient1.getName());
    assertThat(client).isNotEqualTo(null);
    assertThat(client.getName()).isEqualTo(testClient1.getName());
  }
  
  @Test
  public void getClientWithCorrectlyNullResponse() throws Exception {
    Client client = clientService.getClient("NonExistingName");
    assertThat(client).isEqualTo(null);
  }

}
