package com.mj.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by Jun_M on 2015/3/25.
 */
public class RemoteNodeApplication{

    public static void main(String[]args){
        run();
    }
    private static void run() {
        ActorSystem remoteTestSystem = ActorSystem.create("RemoteSys", ConfigFactory.load().getConfig("RemoteSys"));
        ActorRef remoteActor = remoteTestSystem.actorOf(Props.create(RemoteActor.class), "RemoteActor");
        System.out.println(remoteActor.path());
    }
}
