package com.mj.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * This caculating system is to caculating the equation: 1+2+3....+1,000,000
 * Created by Jun_M on 2015/3/20.
 */
public class Main {
    /*
    This system is
     */
    public static void main(String[] args) {
        startCaculatingSystem();
    }

    public static void startCaculatingSystem() {
        ActorSystem caculatingSystem = ActorSystem.create("CaculatingSystem");
        Props props = Props.create(Dispatcher.class);
        ActorRef dispatcher = caculatingSystem.actorOf(props, "Dispatcher");
        dispatcher.tell(new Op.Start(), null);
        System.out.println("starting the startCaculating System");
    }
}
