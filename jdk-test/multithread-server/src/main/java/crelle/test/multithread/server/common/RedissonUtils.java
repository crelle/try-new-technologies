package crelle.test.multithread.server.common;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.RedissonRxClient;
import org.redisson.config.Config;

/**
 * 配置类代替了其功能
 */
public abstract class RedissonUtils {

//    public static RedissonClient createClient(){
//        Config config = new Config();
//        config.useClusterServers().addNodeAddress("redis://192.168.74.3:6379");
//        return Redisson.create(config);
//    }
//
//    public static RedissonReactiveClient createReactiveClient(){
//        Config config = new Config();
//        config.useClusterServers().addNodeAddress("redis://192.168.74.3:6379");
//        return Redisson.createReactive(config);
//    }
//    public static RedissonRxClient createRxClient(){
//        Config config = new Config();
//        config.useClusterServers().addNodeAddress("redis://192.168.74.3:6379");
//        return Redisson.createRx(config);
//    }


}
