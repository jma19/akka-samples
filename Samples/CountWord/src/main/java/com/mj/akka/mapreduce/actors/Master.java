package com.mj.akka.mapreduce.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinPool;
import com.mj.akka.mapreduce.message.FinalResult;
import com.mj.akka.mapreduce.message.MapData;
import com.mj.akka.mapreduce.message.ReduceData;
import com.mj.akka.mapreduce.message.Result;

/**
 * Created by Jun_M on 2015/3/28.
 */
public class Master extends UntypedActor {
    private ActorRef mapActor;
    private ActorRef reduceActor;
    private ActorRef aggregateActor;
    private ActorSystem actorSystem;
    @Override
    public void preStart() throws Exception {
        mapActor= getContext().actorOf(Props.create(MapActor.class).withRouter(new RoundRobinPool(5)), "MapActor");
        reduceActor= getContext().actorOf(Props.create(ReduceActor.class).withRouter(new RoundRobinPool(5)), "ReduceActor");
        aggregateActor=getContext().actorOf(Props.create(AggregateActor.class),"aggregateActor");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            mapActor.tell(message, getSelf());
        }
        else if(message instanceof MapData){
            System.out.println("Master Received from "+getSender().path()+":"+message);
            reduceActor.tell(message, getSelf());
        }else if(message instanceof ReduceData){
            aggregateActor.tell(message,getSelf());

        }else if(message instanceof Result){
          //  aggregateActor.forward(message, getContext());
            aggregateActor.tell(message,getSelf());
        }else if(message instanceof ActorSystem){
            actorSystem=(ActorSystem)message;
        }
        else if(message instanceof FinalResult){
            FinalResult finalResult=(FinalResult)message;
            System.out.println(finalResult.getHashMap());
            if(actorSystem!=null){
                actorSystem.shutdown();
            }
        }
        else{
            unhandled(message);
        }
    }
}
