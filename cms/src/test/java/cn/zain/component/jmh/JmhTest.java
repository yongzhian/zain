/*
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
*/
package cn.zain.component.jmh;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zain on 2016/7/13.
 */
public class JmhTest {
    private static Logger logger = Logger.getLogger(JmhTest.class);
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testConcatenatingStrings() throws Exception {
        System.out.println("just test...");

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    /**
     * 功能说明 ：junit测试try性能
     * @author	Zain 2016/7/14  10:28
     * @return  result
     * @params
     */
    @Test
    public void tryTest() throws Exception {
        logger.info(this.getClass().getSimpleName());
        TryTest tryTest = new TryTest();
        tryTest.tryFor();
        tryTest.forTry();
    }
    /**
     * 功能说明 ：JMH测试try性能
     * @author	Zain 2016/7/14  10:29
     * @return  result
     * @params
     */
    @Test
    public void tryBenchmarkTest() throws Exception {
        Options opt = new OptionsBuilder()
                .include(TryTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }



}
