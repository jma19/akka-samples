package com.mj.akka;

import akka.actor.UntypedActor;

/**
 * Created by Jun_M on 2015/3/20.
 */
public class  Caculator extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof Op.AddOp){
            int result=0;
            Op.AddOp addOp = (Op.AddOp) o;
            for(int i=addOp.getStart();i<=addOp.getEnd();i++){
                result+=i;
            }
            getSender().tell(new Op.Result(addOp.getStart(),addOp.getEnd(),result),getSelf());
        }

    }
}
