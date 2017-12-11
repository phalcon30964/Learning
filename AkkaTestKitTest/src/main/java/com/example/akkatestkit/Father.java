/*******************************************************
 * Copyright (C) 2017 SEON
 *
 * This file is part of Multi-AVL.
 *
 * Multi-AVL can not be copied and/or distributed without the express
 * permission of SEON.
 *******************************************************/

package com.example.akkatestkit;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Father extends AbstractActor {
  
  private ActorRef son;
  
  public Father() {
    System.out.println("Created Father!");
    son = getContext().actorOf(Props.create(Son.class));
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
      .matchEquals("say42", message -> {
        son.tell("42", getSelf());
      })
      .match(Exception.class, (Exception ex) -> {
        throw ex;
      })
      .build();
  }

}
