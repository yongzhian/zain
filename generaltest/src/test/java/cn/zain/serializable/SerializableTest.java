package cn.zain.serializable;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class SerializableTest {
    private static Logger logger = LoggerFactory.getLogger(SerializableTest.class);

    @Test
    public void serializableTest() throws Exception {
        Student stu = new Student(1, 22L, "毛毛");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stu1.txt"));
        oos.writeObject(stu);
        oos.close();
    }

    @Test
    public void deserializableTest() throws Exception {
        FileInputStream fis = new FileInputStream("stu1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student s = (Student) ois.readObject();
        logger.info("{}", s);
    }

    @Test
    public void obj2Xml() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        List<Student> studentList = new ArrayList<>();
        Student stu = new Student(1, 22L, "毛毛");
        studentList.add(stu);
        logger.info(xmlMapper.writeValueAsString(studentList));

        List<Student> ab = xmlMapper.readValue(xmlMapper.writeValueAsString(studentList), List.class);
        logger.info("{}", ab);
    }

    private static class Student implements Serializable {
        //        private static final long serialVersionUID = -4117514262470185083L;
        private int id;
        private Long age;
        private String name;

        public Student() {
        }

        public Student(int id, Long age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Student{");
            sb.append("id=").append(id);
            sb.append(", age=").append(age);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
