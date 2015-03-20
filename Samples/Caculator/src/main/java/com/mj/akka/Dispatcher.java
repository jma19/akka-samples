package com.mj.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by Jun_M on 2015/3/20.
 */
public class Dispatcher extends UntypedActor {

    public static int count=1000;
    private static int currentCount=0;
    public static int totalResult=0;
    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof Op.Start){
            //
            for(int i=0;i<count;i++ ){
                ActorRef caculator = getContext().actorOf(Props.create(Caculator.class), "Caculator"+i);
                caculator.tell(new Op.AddOp(i*1000+1,(i+1)*1000),getSelf());
            }
        }else if(o instanceof Op.Result) {
            Op.Result result = (Op.Result) o;
            totalResult+=result.getResult();
            currentCount+=1;
            System.out.println(getSender().path()+":"+" add from"+result.getStart()+" to "+result.getEnd()+" equal to "+result.getResult());
            if(currentCount==count){
                System.out.println("The total Result is:"+totalResult);
            }
            //close caculator who has finished its task.
            getContext().stop(getSender());
        }
    }
}
