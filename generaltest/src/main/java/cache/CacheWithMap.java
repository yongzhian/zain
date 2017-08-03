package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zain on 2017/8/3.
 */
public class CacheWithMap<K, V> {
    public Map<String, Map<K, V>> cacheMap = new HashMap<>();

    private static CacheWithMap cacheWithMap = new CacheWithMap();

    private CacheWithMap() {
    }

    public static CacheWithMap getInstance() {
        return cacheWithMap;
    }

    public Map<K, V> putCache(String cacheType, Map<K, V> value) {
        return cacheMap.put(cacheType, value);
    }

    public V putCache(String cacheType, K key, V value) {
        if (!cacheMap.containsKey(cacheType)) {
            cacheMap.put(cacheType, new HashMap());
        }
        return cacheMap.get(cacheType).put(key, value);
    }

    public V getCacheValue(String cacheType, K key) {
        if (cacheMap.containsKey(cacheType)) {
            return cacheMap.get(cacheType).get(key);
        }
        return null;
    }

    public Map<K, V> getCache(String cacheType) {
        return cacheMap.get(cacheType);
    }

}
