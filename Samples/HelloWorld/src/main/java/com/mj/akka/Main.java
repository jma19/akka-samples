package com.mj.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**https://github.com/jma19/akka_samples.git
 * Created by Jun_M on 2015/3/20.
 */
public class Main {
    public static void main(String[]args){
        startHelloSystem();
    }
    public static void startHelloSystem(){
        ActorSystem helloSystem = ActorSystem.create("HelloWorldSystem");
        Props props = Props.create(HelloWorldActor.class);
        ActorRef hellWorldActor = helloSystem.actorOf(props, "HellWorldActor");
        hellWorldActor.tell("SayHelloWorld",null);
        System.out.println("starting the helloworld system");
    }
}
