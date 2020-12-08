package com.athuima.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author athuima
 * @create 2020-11-17 19:47
 */
public class JedisTest {

    @Test
    public void testcontinu(){
        //创建一个Jedis连接
        Jedis jedis = new Jedis("192.168.137.22",6379);
        //密码认证  如果设置了密码，就需要进行认证
        jedis.auth("foobared");
        //执行redis命令
        jedis.set("myredis","5");
        //从redis中取值
        String result = jedis.get("myredis");
        System.out.println(result);
        jedis.close();
    }

    @Test
    public void test02(){
        //创建一个Jedis连接
        Jedis jedis = new Jedis("192.168.137.22",6379);
        //密码认证  如果设置了密码，就需要进行认证
        jedis.auth("foobared");
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        Set<String> keys = jedis.keys("k*");
        System.out.println(keys);
        jedis.close();
    }

    @Test
    public void test03(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        //密码认证  如果设置了密码，就需要进行认证
        jedis.auth("foobared");
        jedis.set("mytest","hello world,this is jedis client!");
        String mytest = jedis.get("mytest");
        System.out.println(mytest);
        jedis.close();
    }

    @Test
    public void testHashe(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.hset("zhangsan","name","张三");
        System.out.println(jedis.hget("zhangsan", "name"));
        jedis.close();
    }

    @Test
    public void testList(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.lpush("list1","lv1","lv2","lv3");
        System.out.println(jedis.lrange("list1", 0, -1));
        jedis.close();
    }

    @Test
    public void testSet(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.sadd("Set","v1","v2","v3");
        System.out.println(jedis.smembers("Set"));
        jedis.close();
    }

    @Test
    public void ZsetTest(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.zadd("k5",20,"m1");
        jedis.zadd("k5",30,"m2");
        jedis.zadd("k5",40,"m3");
        System.out.println(jedis.zrange("k5", 0, -1));
        System.out.println(jedis.zrangeByScore("k5", 0, 100));
        jedis.close();
    }

    @Test
    public void GeospatialTest(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.geoadd("china",127.16,45.12,"biejing");
        jedis.geoadd("china",12.16,15.12,"shenzhen");
        System.out.println(jedis.geopos("china", "biejing"));
        jedis.close();
    }

    @Test
    public void HyperLogLogsTest(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.pfadd("pfk","m1","m2");
        System.out.println(jedis.pfcount("pfk"));
        jedis.close();
    }

    @Test
    public void BitMaps(){
        Jedis jedis = new Jedis("192.168.137.22",6379);
        jedis.auth("foobared");
        jedis.set("text","a");
        jedis.setbit("text",6,"1");
        System.out.println(jedis.get("text"));
        jedis.close();
    }

}
