package com.mj.akka.mapreduce.message;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jun_M on 2015/3/27.
 */
public final class MapData implements Serializable{
    //
    private final List<WordCount> dataList;

    public MapData(List<WordCount> dataList) {
        this.dataList = dataList;
    }

    public List<WordCount> getDataList() {
        return dataList;
    }

    @Override
    public String toString() {
        return "MapData{" +
                "dataList=" + dataList +
                '}';
    }
//    public String display(){
//        StringBuffer stringBuffer=new StringBuffer();
//        for(){
//
//        }
//    }
}
