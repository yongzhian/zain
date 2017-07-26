package cn.zain.jdk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by Zain on 2017/4/25.
 */
public class JdkTest {
    private static Logger logger = LoggerFactory.getLogger(JdkTest.class);
    @Test
    public void priorityQueueTest() throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(new Student("a"));  //siftUpComparable要求有序
        priorityQueue.add(new Student("b"));
        priorityQueue.add(new Student("d"));
        priorityQueue.add(new Student("a213"));
        logger.info("{}",priorityQueue.poll());
        logger.info("{}",priorityQueue.poll());
        logger.info("{}",priorityQueue.poll());
        logger.info("{}",priorityQueue.poll());
    }
    class Student{
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
