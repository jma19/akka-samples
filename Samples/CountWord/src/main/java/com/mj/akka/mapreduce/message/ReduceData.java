package com.mj.akka.mapreduce.message;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Jun_M on 2015/3/27.
 */
public class ReduceData implements Serializable{
    private final HashMap<String,Integer> reduceDataList;

    public ReduceData(HashMap<String, Integer> reduceDataList) {
        this.reduceDataList = reduceDataList;
    }

    public HashMap<String, Integer> getReduceDataList() {
        return reduceDataList;
    }
}
