package com.mj.akka;

import java.io.Serializable;

/**
 * Created by Jun_M on 2015/3/20.
 */
public class Op {
    static class Start{

    }
    static class AddOp{
        private int start;
        private int end;

        public AddOp(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    /**
     *
     */
    static class Result implements Serializable{
        private int start;
        private int end;
        private int result;

        public int getResult() {
            return result;
        }
        public Result(int start, int end, int result) {
            this.start = start;
            this.end = end;
            this.result = result;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }
}
