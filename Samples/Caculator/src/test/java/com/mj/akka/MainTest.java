package com.mj.akka;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MainTest{
    @Test
    public void testName() throws Exception {
        int result=0;
        for(int i=1;i<=1000000;i++){
            result+=i;
        }
        assertTrue(result==1784293664);
    }
}