package com.athuima.test;

import redis.clients.jedis.Jedis;

/**
 * @author athuima
 * @create 2020-11-19 11:52
 */
public class SlaveTest {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("192.168.137.22",6379);
        Jedis jedis2 = new Jedis("192.168.137.22",6380);
        jedis2.slaveof("192.168.137.22",6379);
        jedis.set("son","儿子儿子");
        Thread.sleep(3000);
        System.out.println(jedis2.get("son"));
    }

}
