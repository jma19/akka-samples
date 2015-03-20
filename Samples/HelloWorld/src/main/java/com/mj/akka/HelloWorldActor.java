package com.mj.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by Jun_M on 2015/3/20.
 */
public class  HelloWorldActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if(o=="SayHelloWorld"){
            ActorRef replyActor = getContext().actorOf(Props.create(ReplyActor.class), "ReplyActor");
            System.out.println(getSelf().path()+": have sent an message: helloworld!");
            replyActor.tell("HelloWorld", getSelf());
        }
        else if(o=="bye"){
            System.out.println(getSelf().path()+": have received a message: bye!");
            getContext().stop(getSender());

        }

    }
}
