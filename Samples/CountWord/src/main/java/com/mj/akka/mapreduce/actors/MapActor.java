package com.mj.akka.mapreduce.actors;

import akka.actor.UntypedActor;
import com.mj.akka.mapreduce.message.MapData;
import com.mj.akka.mapreduce.message.WordCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Jun_M on 2015/3/27.
 */

public class MapActor extends UntypedActor {
    static String[] STOP_WORDS = {"a", "am", "an", "and", "be", "as", "do", "go"};

    private static List<String> STOP_WORDS_LIST = Arrays.asList(STOP_WORDS);

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            String work = (String) message;
            getSender().tell(evalueteExpression(work), getSelf());

        } else {
            unhandled(message);
        }
    }

    public static MapData evalueteExpression(String line) {
        List<WordCount> list = new ArrayList<WordCount>();
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken().toLowerCase();
            if (!STOP_WORDS_LIST.contains(word)) {
                list.add(new WordCount(word, new Integer(1)));
            }
        }
        return new MapData(list);
    }
}
