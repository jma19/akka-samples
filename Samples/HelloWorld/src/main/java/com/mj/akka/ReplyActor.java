package com.mj.akka;

import akka.actor.UntypedActor;

/**
 * Created by Jun_M on 2015/3/20.
 */
public class ReplyActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if(o=="HelloWorld"){
            System.out.println(getSelf().path()+":"+" have received a message:HelloWorld!");
            System.out.println(getSelf().path()+":"+" have sent a message:bye!");
            getSender().tell("bye",getSelf());
        }

    }
}
