package org.example.akka.actor;

import javax.inject.Named;

import org.example.akka.message.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.AbstractActor;

@Named("myActor")
@Scope("prototype")
public class MyActor extends AbstractActor {

	private String attribute;
	private Integer attribute2;
	
	public MyActor(String attribute, Integer attribute2) {
		super();
		this.attribute = attribute;
		this.attribute2 = attribute2;
	}

	public MyActor() {
		this.attribute = "NoParams";
		this.attribute2 = 10;
	}
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().matchEquals(Message.MSG, msg -> {
			System.out.println(getSelf().path() + " " + attribute + " " + attribute2);
		}).build();
	}
}
