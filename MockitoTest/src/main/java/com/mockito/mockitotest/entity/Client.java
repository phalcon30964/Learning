package com.mockito.mockitotest.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {

  @Indexed
  private String name;
  private String nickname;
  
  public Client() {}
  
  public Client(String name, String nickname) {
    super();
    this.name = name;
    this.nickname = nickname;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  @Override
  public String toString() {
    return "Client [name=" + name + ", nickname=" + nickname + "]";
  }
  
}
