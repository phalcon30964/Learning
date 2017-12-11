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

public class Son extends AbstractActor {

  public Son() {
    System.out.println("Created Son!");
  }
  
  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .matchEquals("42", msg -> {
          getSender().tell("42", getSelf());
        })
        .build();
  }

}
