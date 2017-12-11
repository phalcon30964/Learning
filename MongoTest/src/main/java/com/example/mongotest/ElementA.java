package com.example.mongotest;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ElementA {

  @Id
  private String id;
  @Indexed
  private String name;
  private String attribute;
  private List<ElementB> elementB;
  
}