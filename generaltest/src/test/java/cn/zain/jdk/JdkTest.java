package cn.zain.jdk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by Zain on 2017/4/25.
 * 优先堆的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。
 * 无序插入到priorityQueue，最后有序输出
 */
public class JdkTest {
    private static Logger logger = LoggerFactory.getLogger(JdkTest.class);
    @Test
    public void priorityQueueTest() throws Exception {
        PriorityQueue<Student> priorityQueue = new PriorityQueue();
        priorityQueue.add(new Student("a"));  //siftUpComparable要求有序
        priorityQueue.add(new Student("b"));
        priorityQueue.add(new Student("d"));
        priorityQueue.add(new Student("a213"));
        logger.info("{}",priorityQueue.poll());
        logger.info("{}",priorityQueue.poll());
        logger.info("{}",priorityQueue.poll());
        logger.info("{}",priorityQueue.poll());
    }
    class Student implements Comparable<Student>{
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

        @Override
        public int compareTo(Student o) {
            return this.name.compareTo(o.name);
        }
    }
}
