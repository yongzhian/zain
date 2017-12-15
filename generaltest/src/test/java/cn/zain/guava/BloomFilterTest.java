package cn.zain.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class BloomFilterTest {
    private static int insertions = 100_0000;// 100w
    private static Logger logger = LoggerFactory.getLogger(BloomFilter.class);

    @Test
    public void bloomFilterTest() throws Exception {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions, 0.03);
        HashSet<String> set = new HashSet<>(insertions); //实际的黑名单
        ArrayList<String> list = new ArrayList<>(insertions); //随机取出字符串

        for (int i = 0; i < insertions; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            set.add(uuid);
            list.add(uuid);
        }

        int wrong = 0;
        int right = 0;

        int white = 0;
        for (int i = 0; i < 10000; i++) {
            //按比例取出一定存在的String
            String test = i % 100 == 0 ? list.get(i / 100) : UUID.randomUUID().toString();//1/100一定是存在黑名单中
            if (bloomFilter.mightContain(test)) {//布隆黑名单
                if (set.contains(test)) {
                    right++;
                } else {//误伤数
                    wrong++;
                }
            }else{
                white ++;
            }
        }
        logger.info("right:{}",right);
        logger.info("wrong:{}",wrong);
        logger.info("white:{}",white);
    }
}
