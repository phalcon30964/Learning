package com.example.mongotest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MongotestApplication {

//  public static void main(String[] args) {
//    ConfigurableApplicationContext context = SpringApplication.run(MongotestApplication.class, args);
//    Mongonnection repo = context.getBean(Mongonnection.class);
//    
//    List<ElementB> elementsB = new ArrayList<>();
//    elementsB.add(new ElementB("attribute1", Arrays.asList("q","w","e")));
//    elementsB.add(new ElementB("attribute2", Arrays.asList("r","t","y")));
//    ElementA element = new ElementA("elementA", "myname", "Some attribute", elementsB);
//    
//    repo.save(element);
//    
//    System.out.println(repo.count());
//    
//    List<ElementA> elements = repo.findAll();
//    for(ElementA e : elements) {
//      System.out.println(e.getName());
//      for(ElementB b : e.getElementB()) {
//        System.out.println(b.getAttributeA());
//        for(String s : b.getList()) {
//          System.out.println(s);
//        }
//      }
//    }
//  }
}
