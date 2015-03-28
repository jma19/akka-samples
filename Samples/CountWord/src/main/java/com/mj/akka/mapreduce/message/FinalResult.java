package com.mj.akka.mapreduce.message;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Jun_M on 2015/3/28.
 */
public class FinalResult implements Serializable{
    private final HashMap<String,Integer> hashMap;

    public FinalResult(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }
}
