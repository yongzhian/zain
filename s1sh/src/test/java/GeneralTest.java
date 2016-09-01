import cn.zain.spi.Search;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.*;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.ServiceLoader;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class GeneralTest {
    private Logger logger = Logger.getLogger(GeneralTest.class);

    @Test
    public void char2IntTest() throws Exception {
        logger.info(Calendar.getInstance().getTime());
        logger.info(Calendar.getInstance().getTime().getTime());
        logger.info(System.currentTimeMillis());
        char c = '鱀';
        int f = 50000;
        logger.info((int) c);
        logger.info((char) 10000);
        logger.info((char) 20000);
        logger.info((char) 30000);
    }


    @Test
    public void spiTest() throws Exception {
        ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);
        for (Search service : serviceLoader) {
            service.searchData();
        }
    }

    @Test
    public void spi4mysqlTest() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Enumeration<Driver> emums = DriverManager.getDrivers();
        while (emums.hasMoreElements()) {
            Driver driver = emums.nextElement();
            System.out.println(driver.getClass() + " : " + driver.getClass().getClassLoader());
        }
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(DriverManager.class.getClassLoader());

    }

    @Test
    public void jdbcTest() throws Exception {
//       Class.forName("com.mysql.jdbc.Driver");
//        logger.info("class for name");
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.243:3306/dosee", "root", "root4flw");
        PreparedStatement ps = con.prepareStatement("select * from sys_user");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            logger.info(rs.getString("username"));
        }
        ps.close();
        con.close();
    }

    @Test
    public void bigFileReadTest() throws Exception {
        String filePath = "C:\\Users\\Zain\\Desktop\\catalina.out";
        int buffer_size_16 = 0x10000; //16进制3Mb 换算 3*16的5次方 即3*2的20次方
        File f = new File(filePath);
        logger.info("原始文件大小 : " + f.length() / 1024.0 / 1024 / 1024 + " GB");
        MappedByteBuffer inputBuffer = new RandomAccessFile(f, "r").getChannel().map(FileChannel.MapMode.READ_ONLY,
                f.length() * 99999 / 100000, f.length() / 100000);

        byte[] bytes = new byte[buffer_size_16]; //每次读取3Mb
        int num = 0;
        logger.info("读取部分文件大小 ： " + inputBuffer.capacity() / 1024.0 / 1024 + " MB");
        for (int offset = 0; offset < inputBuffer.capacity(); offset += buffer_size_16) { //每次递增缓存容量的大小
            logger.info("offset : " + offset);
            if (inputBuffer.capacity() - offset >= buffer_size_16) { //如果剩余部分大于缓存 则一直取
                for (int i = 0; i < buffer_size_16; i++) {
                    bytes[i] = inputBuffer.get(offset + i); //读取到缓存中
                }
            } else {
                for (int i = 0; i < inputBuffer.capacity() - offset; i++) {
                    bytes[i] = inputBuffer.get(offset + i);
                }
            }

            //  输出读取部分
            int length = inputBuffer.capacity() % buffer_size_16 == 0 ? buffer_size_16 : inputBuffer.capacity() % buffer_size_16;
            num++;
            logger.info("结果 :" + new String(bytes, 0, length));
        }
        logger.info("共读取次数 ： " + num);
    }

    @Test
    public void bigFileSimpleReadTest() throws Exception {
        String filePath = "C:\\Users\\Zain\\Desktop\\catalina.out";
        int buffer_size_16 = 10; //16进制3Mb 换算 3*16的5次方 即3*2的20次方
        byte[] bs = new byte[buffer_size_16];
        ByteBuffer byteBuf = ByteBuffer.allocate(10);
        FileChannel channel = new RandomAccessFile(filePath, "r").getChannel();
        while (channel.read(byteBuf) != -1) {
            int size = byteBuf.position();
            byteBuf.rewind();
            byteBuf.get(bs); // 把文件当字符串处理，直接打印做为一个例子。
            logger.info(new String(bs, 0, size));
            byteBuf.clear();
        }
    }

    @Test
    public void bigFileSimpleReadByLineTest() throws Exception {  //直接按行读取
        String filePath = "C:\\Users\\Zain\\Desktop\\catalina.out";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = null;
        int i = 0;
        while ((line = br.readLine()) != null) {
            i++;
            logger.info(i + "行" + line);
        }
        br.close();
    }
    @Test
    public void bigFileSimpleReadByMulLineTest() throws Exception {  //直接多行读取
        String filePath = "C:\\Users\\Zain\\Desktop\\catalina.out";
        RandomAccessFile br=new RandomAccessFile(filePath,"rw");//这里rw看你了。要是只读就只写r
        String str = null, app = null;
        int i=0;
        while ((str = br.readLine()) != null) {
            i++;
            app=app+str;
            if(i>=100){//假设读取100行
                i=0;
//				这里你先对这100行操作，然后继续读
                logger.info(app);
                app=null;
            }
        }
        br.close();
    }

}
