package cache;

import org.apache.log4j.Logger;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

import java.util.Map;

/**
 * Created by Zain on 2017/8/3.
 */
public class CacheWithEhcache<K, V> {
    private static Logger logger = Logger.getLogger(CacheWithEhcache.class);

    private static CacheWithEhcache cacheWithEhcache = new CacheWithEhcache();

    private CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);

    private CacheWithEhcache() {
    }

    public static CacheWithEhcache getInstance() {
        return cacheWithEhcache;
    }

    public void putCache(String cacheType, K key, V value) {
        try {

            Cache<K, V> cache = cacheManager.getCache(cacheType, (Class<K>) key.getClass(), (Class<V>) value.getClass());
            if (null == cache) {
                cache = cacheManager.createCache(cacheType,
                        CacheConfigurationBuilder.newCacheConfigurationBuilder((Class<K>) key.getClass(), (Class<V>) value.getClass(),
                                ResourcePoolsBuilder.newResourcePoolsBuilder().heap(2, MemoryUnit.MB)).build()); //heap容量 key存在直接报错
            }
            cache.put(key, value);
        } catch (Exception e) {
            logger.error("", e);
        }
    }


}
