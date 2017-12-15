package cn.zain.jdk.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Zain on 2017/7/18.
 * 并发测试
 */
public class GateWay {
    private static Logger logger = LoggerFactory.getLogger(GateWay.class);
    public static void main(String[] args) {
        int threadNum = 10000;
        CountDownLatch cdl = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++){
            Student student = new Student("s"+i,i);
            Bu bu = new Bu(Process.getInstance(),student,cdl);
            bu.start();
            cdl.countDown();
        }

    }


}
class Bu extends Thread{
    private static Logger logger = LoggerFactory.getLogger(Bu.class);
    private Process process;
    private Student student;
    private CountDownLatch cdl;
    public Bu(Process process, Student student,CountDownLatch cdl ) {
        this.process = process;
        this.student = student;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("{} 执行..",process.hashCode());
        process.dealStu(student);
    }
}