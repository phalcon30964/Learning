package org.example;

import org.example.akka.di.SpringExtension;
import org.example.akka.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		ActorSystem system = context.getBean("actorSystem", ActorSystem.class);
		SpringExtension springExtension = context.getBean("springExtension", SpringExtension.class);
		
		ActorRef myActor1 = system.actorOf(springExtension.props("myActor", "HEY", 100), "TheActor1");
		myActor1.tell(Message.MSG, ActorRef.noSender());
		
		ActorRef myActor2 = system.actorOf(springExtension.props("myActor"), "TheActor2");
		myActor2.tell(Message.MSG, ActorRef.noSender());
		
		System.out.println("Sent");
	}
}
