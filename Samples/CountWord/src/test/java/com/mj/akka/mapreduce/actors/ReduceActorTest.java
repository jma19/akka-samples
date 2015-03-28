package com.mj.akka.mapreduce.actors;

import com.mj.akka.mapreduce.message.MapData;
import com.mj.akka.mapreduce.message.ReduceData;
import com.mj.akka.mapreduce.message.WordCount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReduceActorTest
{

    @Test
    public void test_reduce_function() throws Exception {
        ArrayList<WordCount> dataList = new ArrayList<WordCount>();
        dataList.add(new WordCount("ubc",1));
        dataList.add(new WordCount("majun",1));
        dataList.add(new WordCount("ACD",1));
        dataList.add(new WordCount("majun",1));
        dataList.add(new WordCount("America",1));
        dataList.add(new WordCount("Canda",1));
        dataList.add(new WordCount("majun",1));


        MapData mapData=new MapData(dataList);
        ReduceData reduce = ReduceActor.reduce(mapData);
        HashMap<String, Integer> reduceDataList = reduce.getReduceDataList();
        for(Map.Entry<String, Integer> entry: reduceDataList.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }
    }

    @Test
    public void testMap() throws Exception {
        HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
        hashMap.put("majun",2);
        hashMap.put("majun",1);
        System.out.println(hashMap.get("majun"));
    }
}