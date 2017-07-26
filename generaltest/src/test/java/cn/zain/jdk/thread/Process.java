package cn.zain.jdk.thread;

import cn.zain.jdk.JdkTest;
import org.apache.log4j.Logger;

/**
 * Created by Zain on 2017/7/18.
 */
public class Process {
    private static Logger logger = Logger.getLogger(Process.class);
    private Process processFlwMessage = null;
    private  Student student1;

    public static Process getInstance() {
        return Inner.processFlwMessage;
    }

    private static class Inner { //内部类实现单例，第一次调用时创建
        private static Process processFlwMessage = new Process();
    }

    public synchronized void dealStu(Student student){
        student1 = new Student(student.getName(),student.getAge());
        try {
        Thread.sleep(110);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        student1.setAge(student.getAge());
        if(student1.getAge() != student.getAge()){

            logger.info(student1 + " -----student" + student);
        }
    }

}
