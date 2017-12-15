package cn.zain.jdk.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zain on 2017/7/18.
 */
public class GateWay {
    private static Logger logger = LoggerFactory.getLogger(GateWay.class);
    public static void main(String[] args) {

        for(int i=0;i<10000;i++){
            Student student = new Student("s"+i,i);

            Bu bu = new Bu(Process.getInstance(),student);
            bu.start();
            logger.info("{}",i);
        }

    }


}
class Bu extends Thread{
    private Process process;
    private Student student;

    public Bu(Process process, Student student) {
        this.process = process;
        this.student = student;
    }

    @Override
    public void run() {
        process.dealStu(student);
    }
}