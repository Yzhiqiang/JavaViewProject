package com.yu.FX;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 23:37 2022/2/20
 * @Modified By:
 */
public class UseLinkedHashMapCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;
    public UseLinkedHashMapCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
