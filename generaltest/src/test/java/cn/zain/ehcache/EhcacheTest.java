package cn.zain.ehcache;

import cache.CacheWithMap;
import cache.RobotTaskDef;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zain on 2017/8/3.
 */
public class EhcacheTest {
    private static Logger logger = LoggerFactory.getLogger(EhcacheTest.class);

    @Test
    public void cacheCompare() throws Exception {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);

        List<RobotTaskDef> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new RobotTaskDef("taskType" + i, "taskName" + i, "taskCode" + i));
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                CacheWithMap.getInstance().putCache("def" + i, list.get(j).getTaskType(), list.get(j));
            }
        }
        for (int i = 0; i < 1000; i++) {
            Map map = CacheWithMap.getInstance().getCache("def" + i);
            if (i == 100 || i == 910) {
                logger.info("{}", map.get("taskType527"));
            }
        }
        logger.info("map耗时：" + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Cache<String, RobotTaskDef> myCache = cacheManager.createCache("def" + i,
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, RobotTaskDef.class,
                            ResourcePoolsBuilder.heap(1000)).build()); //heap容量 key存在直接报错
            for (int j = 0; j < 1000; j++) {
                myCache.put(list.get(j).getTaskType(), list.get(j));
            }
        }
        for (int i = 0; i < 1000; i++) {
            Cache<String, RobotTaskDef> myCache = cacheManager.getCache("def" + i, String.class, RobotTaskDef.class);
            if (i == 100 || i == 910) {
                logger.info("{}",myCache.get("taskType527"));
            }
        }

        logger.info("Cache耗时：" + (System.currentTimeMillis() - start) + "ms");


        Cache<Long, String> myCache = cacheManager.createCache("preConfigured",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                        ResourcePoolsBuilder.heap(2)).build()); //heap容量 key存在直接报错
        myCache.put(1L, "da one!");
        myCache.put(2L, "da one!");
        myCache.put(3L, "da one!");
        String value = myCache.get(1L);
        logger.info(value);
        value = myCache.get(2L);
        logger.info(value);
        value = myCache.get(3L);
        logger.info(value);

        logger.info("{}",cacheManager.getCache("preConfigured1", Long.class, String.class) == null);

        cacheManager.close();


    }

}
