package com.mj.akka.mapreduce.message;

import java.io.Serializable;

/**
 * Created by Jun_M on 2015/3/27.
 */
public class WordCount implements Serializable{
    private final String word;
    private final Integer count;

    public WordCount(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
