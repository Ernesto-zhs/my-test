package com.shadow.lru;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Integer> map = new HashMap<>();

    /**
     * 键的数组
     */
    private int[] keyArr;

    public LRUCache(int capacity) {
        this.keyArr = new int[capacity];
    }

    public Integer get(Integer key) {
        Integer val = map.getOrDefault(key, -1);
        if (val >= 0) {
            moveKey(key);
        }
        return val;
    }

    public void put(Integer key, Integer value) {
        if (value < 0) {
            return;
        }
        map.put(key, value);
        int movedKey = moveKey(key);
        if (movedKey > 0) {
            map.remove(movedKey);
        }
    }

    private int moveKey(Integer key) {
        int[] tempArr = new int[keyArr.length];
        tempArr[0] = key;
        Boolean flag = Boolean.FALSE;
        for (int i = 0; i < keyArr.length; i++) {
            if (Boolean.TRUE.equals(flag)) {
                tempArr[i] = keyArr[i];
            } else if ((keyArr[i] == key)) {
                flag = Boolean.TRUE;
            } else if (i + 1 < keyArr.length) {
                tempArr[i + 1] = keyArr[i];
            }
        }
        int removeKey = Boolean.TRUE.equals(flag) ? -1 : keyArr[keyArr.length - 1];
        this.keyArr = tempArr;
        return removeKey;
    }

    @SneakyThrows
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        return "LRUCache{" +
                "map=" + objectMapper.writeValueAsString(map) +
                ", keyArr=" + objectMapper.writeValueAsString(keyArr) +
                '}';
    }
}
