package com.ibesh.rpi.statistic;

import lombok.ToString;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ToString
public class DHTStatistic {
    private final Map<String, AtomicInteger> statistics = new ConcurrentHashMap<>();

    public int increment(String key){
        if (statistics.containsKey(key)) {
            return statistics.get(key).incrementAndGet();
        } else {
            statistics.put(key, new AtomicInteger());
            return statistics.get(key).incrementAndGet();
        }
    }

    public int get(String key){
        return statistics.containsKey(key) ? statistics.get(key).get() : 0;
    }

    public Set<String> getKeys(){
        return statistics.keySet();
    }

    public Set<Map.Entry<String, AtomicInteger>> getEntrySet(){
        return statistics.entrySet();
    }
}
