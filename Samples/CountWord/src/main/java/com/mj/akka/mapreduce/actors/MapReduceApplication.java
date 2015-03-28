package com.mj.akka.mapreduce.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.mj.akka.mapreduce.message.Result;


/**
 * Created by Jun_M on 2015/3/28.
 */
public class MapReduceApplication {
    public static void main(String[]args) throws InterruptedException {
        ActorSystem mapReduceApp = ActorSystem.create("MapReduceApp");
        ActorRef master = mapReduceApp.actorOf(Props.create(Master.class), "master");
        master.tell("Whether you are exploring undergraduate or",ActorRef.noSender());
        master.tell("graduate studies searching for information on tuition and scholarships",ActorRef.noSender());
        master.tell("or ready to start your future at UBC",ActorRef.noSender());
        master.tell("we are here for you Your decision is very important to us",ActorRef.noSender());
        master.tell(mapReduceApp, ActorRef.noSender());
        Thread.sleep(5000);
        master.tell(new Result(),ActorRef.noSender());

    }
}
