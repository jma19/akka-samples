package com.mj.akka.mapreduce.actors;

import akka.actor.UntypedActor;
import com.mj.akka.mapreduce.message.FinalResult;
import com.mj.akka.mapreduce.message.ReduceData;
import com.mj.akka.mapreduce.message.Result;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Jun_M on 2015/3/28.
 */
public class AggregateActor extends UntypedActor {
    private HashMap<String, Integer> finalResult=new HashMap<String, Integer>();

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof ReduceData){
            ReduceData reduceData=(ReduceData)message;
            HashMap<String, Integer> reduceDataList = reduceData.getReduceDataList();
            Set<String> keySet = reduceDataList.keySet();
            for(String key:keySet){
                if(finalResult.containsKey(key)){
                    Integer integer = reduceDataList.get(key);
                    int newValue = finalResult.get(key) + integer;
                    finalResult.put(key,newValue);
                }
                else{
                    finalResult.put(key,reduceDataList.get(key));
                }
            }
        }
        else if(message instanceof Result){
            System.out.println("Aggregator received Result information from "+getSender().path());
            getSender().tell(new FinalResult(finalResult), getSelf());
        }else{
            unhandled(message);
        }
    }

    @Override
    public String toString() {
        return "AggregateActor{" +
                "finalResult=" + finalResult +
                '}';
    }
}
