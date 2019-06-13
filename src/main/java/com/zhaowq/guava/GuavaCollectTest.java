package com.zhaowq.guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author zhaowq
 * @date 2016/5/10
 */
public class GuavaCollectTest {
    public static void main(String[] args) {
        //测试一：BiMap
        BiMap<String, String> biMap = HashBiMap.create();
        Preconditions.checkNotNull(biMap);
    }
}
