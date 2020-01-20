package com.example.rest4;

public interface RedisClient {

    <T> void put(String key, T value);

    <T> T get(String key);

}