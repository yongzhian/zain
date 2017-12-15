package cn.zain.jdk.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Zain on 2017/7/18.
 */
public class Process {
    private static Logger logger = LoggerFactory.getLogger(Process.class);
    private Student student1;

    public static Process getInstance() {
        return Inner.processFlwMessage;
    }

    private static class Inner { //内部类实现单例，第一次调用时创建
        private static Process processFlwMessage = new Process();
    }

    public void dealStu(Student student) {
        student1 = new Student(student.getName(), student.getAge());
        student1.setAge(student.getAge());
        if (student1.getAge() != student.getAge()) {
            logger.info(student1 + " -----student" + student);
        }
    }

}
