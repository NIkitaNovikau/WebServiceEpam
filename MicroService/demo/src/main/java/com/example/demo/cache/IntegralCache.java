package com.example.demo.cache;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository//пометка класса, который предоставляет механизм хранения, поиска, изменения и удаления данных.
public class IntegralCache {

    private final Map<String, Double> cache = new ConcurrentHashMap<>();

    public Map<String, Double> getCache() {
        return cache;
    }

}
