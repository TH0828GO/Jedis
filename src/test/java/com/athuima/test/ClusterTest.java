package com.athuima.test;

import redis.clients.jedis.HostAndPort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author athuima
 * @create 2020-11-19 15:49
 */
public class ClusterTest {
    public static void main(String[] args) throws Exception {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.137.22",7291));
        redis.clients.jedis.JedisCluster jedisCluster = new redis.clients.jedis.JedisCluster(nodes);
        jedisCluster.set("username","admin");
        String username = jedisCluster.get("username");
        System.out.println(username);
        jedisCluster.close();
    }
}
