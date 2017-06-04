import org.junit.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class JedisTester{
    private Jedis jedis;

    @Before
    public void before(){
        jedis=new Jedis("120.24.244.103",6379);
    }
    @After
    public void after(){}
    @Test
    public  void  testTransaction(){
        int balance,dept,amtToSubtract=10;
        jedis .watch("balance");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amtToSubtract>Integer.parseInt(jedis.get("balance"))){
            jedis.unwatch();
            Transaction transaction=jedis.multi();
            transaction.set("balance","10000");
            transaction.exec();
            System.out.print("balance is not enough!-->"+jedis.get("balance"));
            return;
        }
        Transaction transaction=jedis.multi();
        transaction.decrBy("balance",amtToSubtract);
        transaction.incrBy("dept",amtToSubtract);
        transaction.exec();


//        transaction.set("k4" ,"v44");
//        transaction.set("k5","v55");
//        transaction.discard();
//        for (String s:jedis.keys("*")){
//            System.out.println(jedis.get(s));
//        }

    }

    @Test
    public void testAPI(){
        jedis.set("k1","v1");
        System.out.print(jedis.get("k1"));

//        System.out.println(jedis.dbSize());
//        jedis.flushAll();
//        System.out.println(jedis.info("replication"));
//        System.out.println(jedis.dbSize());
    }
    @Test
    public void testPing(){
        System.out.print(jedis.ping());
    }

}