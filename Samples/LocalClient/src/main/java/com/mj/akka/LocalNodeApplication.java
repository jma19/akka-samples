package com.mj.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by Jun_M on 2015/3/25.
 */
public class LocalNodeApplication{
    public static void main(String[]args) throws InterruptedException {
        ActorSystem actorSystem = ActorSystem.create("LocalNodeApp", ConfigFactory.load().getConfig("LocalSys"));
        ActorRef localActor = actorSystem.actorOf(Props.create(LocalActor.class), "LocalActor");
        localActor.tell("Hello", ActorRef.noSender());
        Thread.sleep(5000);
        actorSystem.shutdown();
    }
}
