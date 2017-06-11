import org.junit.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import testPool.JedisPoolUtil;

import java.util.Set;

public class JedisTester{
    private Jedis jedis79,jedis80;

    @Before
    public void before(){
        jedis79=new Jedis("120.24.244.103",6379);
        //jedis80=new Jedis("120.24.244.103",6380);
    }
    @After
    public void after(){}
    @Test
    public void testJedisPool(){
        JedisPool jedisPool= JedisPoolUtil.getInstance();
//        JedisPool jedisPool2= JedisPoolUtil.getInstance();
//        System.out.println(jedisPool2==jedisPool);
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            System.out.print(jedis.ping());
            jedis.set("aa","bb");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPoolUtil.release(jedis);
        }
    }
    @Test
    public void testMasterAndSlave(){
        jedis80.slaveof("120.24.244.103",6379);
        jedis79.set("class","1122V5");
        System.out.print(jedis80.get("class"));
    }
    @Test
    public  void  testTransaction(){
        int balance,dept,amtToSubtract=10;
        jedis79 .watch("balance");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amtToSubtract>Integer.parseInt(jedis79.get("balance"))){
            jedis79.unwatch();
            Transaction transaction=jedis79.multi();
            transaction.set("balance","10000");
            transaction.exec();
            System.out.print("balance is not enough!-->"+jedis79.get("balance"));
            return;
        }
        Transaction transaction=jedis79.multi();
        transaction.decrBy("balance",amtToSubtract);
        transaction.incrBy("dept",amtToSubtract);
        transaction.exec();


//        transaction.set("k4" ,"v44");
//        transaction.set("k5","v55");
//        transaction.discard();
//        for (String s:jedis79.keys("*")){
//            System.out.println(jedis79.get(s));
//        }

    }

    @Test
    public void testAPI(){
        jedis79.set("k1","v1");
        System.out.print(jedis79.get("k1"));

//        System.out.println(jedis79.dbSize());
//        jedis79.flushAll();
//        System.out.println(jedis79.info("replication"));
//        System.out.println(jedis79.dbSize());
    }
    @Test
    public void testPing(){
        System.out.print(jedis79.ping());
    }

}