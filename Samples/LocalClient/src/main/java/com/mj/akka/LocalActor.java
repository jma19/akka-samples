package com.mj.akka;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class LocalActor extends UntypedActor {

    Timeout timeOut=new Timeout(Duration.apply(5, TimeUnit.SECONDS));
    ActorSelection actorSelection;
    @Override
    public void preStart() throws Exception {
         actorSelection = getContext().actorSelection("akka.tcp://RemoteSys@192.168.1.103:2552/user/RemoteActor");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            Future<Object> ask = Patterns.ask(actorSelection, message.toString(), timeOut);

            String result=(String) Await.result(ask,timeOut.duration());
            System.out.println("Message received from Server->"+result);

        }
    }
}