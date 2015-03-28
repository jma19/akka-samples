package com.mj.akka.mapreduce.actors;

import akka.actor.UntypedActor;
import com.mj.akka.mapreduce.message.MapData;
import com.mj.akka.mapreduce.message.ReduceData;
import com.mj.akka.mapreduce.message.WordCount;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jun_M on 2015/3/27.
 */
public class ReduceActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof MapData){
            //reduce the incoming data and forward the result to the master
            MapData mapData=(MapData)message;
            getSender().tell(reduce(mapData),getSelf());
        }
    }

    public static ReduceData reduce(MapData mapData){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<WordCount> dataList = mapData.getDataList();
        for(WordCount wordCount:dataList){
            String word = wordCount.getWord();
            Integer integer = map.get(word);

            if(integer!=null){
                map.put(word, integer + wordCount.getCount());
            }
            else{
                map.put(word,wordCount.getCount());
            }
        }

        return new ReduceData(map);
    }
}
