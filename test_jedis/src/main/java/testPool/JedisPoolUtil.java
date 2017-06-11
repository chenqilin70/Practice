package testPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by aierxuan on 2017/6/4.
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool;
    private JedisPoolUtil(){}
    public static JedisPool getInstance(){
        if(jedisPool==null){
            synchronized (JedisPoolUtil.class){
                if(jedisPool==null){
                    JedisPoolConfig poolConfig=new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(5);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool=new JedisPool(poolConfig,"120.24.244.103",6379);
                    return jedisPool;
                }
            }
        }
        return jedisPool;
    }
    public static void release(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }

}
