/*
 * Copyright (c) 2016 www.flwrobot.com. All Rights Reserved.
*/
package cn.zain.component.jmh;

import org.junit.Before;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zain on 2016/7/14.
 */
public class ToStringTest {
    public static String att1 ="att1";
    public static String att2 = "att2";
    public static String att3 = "att3";

    @Before
    public void before() throws Exception {

    }

    //----------------------------------JMH方法测试-------------------------------------------
    /**
     * 功能说明 ：JMH测试try性能
     * @author	Zain 2016/7/14  10:29
     * @return  result
     * @params
     */
    @Test
    public void benchmarkTest() throws Exception {
        Options opt = new OptionsBuilder()
                .include(ToStringTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void toStringConcatBenchmark() {
        int j = 3;
        try {
            for (int i = 0; i < 1000000; i++) {
                toStringConcat();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void toStringSbBenchmark() {
        int j = 3;
        for (int i = 0; i < 1000000; i++) {
            try {
                toStringSb();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void toStringStringBuilderBenchmark() {
        int j = 3;
        for (int i = 0; i < 1000000; i++) {
            try {
                toStringStringBuilder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//----------------------------------system out 方法测试-------------------------------------------

    /**
     * 功能说明 ：junit测试try性能
     * @author	Zain 2016/7/14  10:28
     * @return  result
     * @params
     */
    @Test
    public void simpleTest() throws Exception {
        System.out.println("toStringConcat ---------------------------------");
        long startTime = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1000000; i++) {
                toStringConcat();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("toStringConcat " + (endTime - startTime) + " milliseconds");

        System.out.println("toStringSb ---------------------------------");
        startTime = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1000000; i++) {
                toStringSb();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        System.out.println("toStringSb " + (endTime - startTime) + " milliseconds");


        System.out.println("toStringStringBuilder ---------------------------------");
        startTime = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1000000; i++) {
                toStringStringBuilder();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        System.out.println("toStringStringBuilder " + (endTime - startTime) + " milliseconds");


    }

    public String toStringConcat() {
        return "ToStringTest{" +
                "att1='" + att1 + '\'' +
                ", att2='" + att2 + '\'' +
                ", att3='" + att3 + '\'' +
                '}';
    }

    public String toStringSb() {
        final StringBuffer sb = new StringBuffer("ToStringTest{");
        sb.append("att1='").append(att1).append('\'');
        sb.append(", att2='").append(att2).append('\'');
        sb.append(", att3='").append(att3).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String toStringStringBuilder() {
        final StringBuilder sb = new StringBuilder("ToStringTest{");
        sb.append("att1='").append(att1).append('\'');
        sb.append(", att2='").append(att2).append('\'');
        sb.append(", att3='").append(att3).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
