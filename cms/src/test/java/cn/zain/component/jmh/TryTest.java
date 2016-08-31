/*
 * Copyright (c) 2016 www.flwrobot.com. All Rights Reserved.
*/
package cn.zain.component.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zain on 2016/7/14.
 */
public class TryTest {
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void tryForBenchmark() {
        int j = 3;
        try {
            for (int i = 0; i < 1000000; i++) {
                Math.sin(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void forTryBenchmark() {
        int j = 3;
        for (int i = 0; i < 1000000; i++) {
            try {
                Math.sin(j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tryFor() {
        long startTime = System.currentTimeMillis();

        int j = 3;
        try {
            for (int i = 0; i < 1000000; i++) {
                Math.sin(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("tryFor " + (endTime - startTime) + " milliseconds");
    }
    public void forTry() {
        long startTime = System.currentTimeMillis();


        int j = 3;
        for (int i = 0; i < 1000000; i++) {
            try {
                Math.sin(j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("forTry " + (endTime - startTime) + " milliseconds");

    }
}
