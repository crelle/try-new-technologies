package crelle.test.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.RedissonRxClient;
import org.redisson.config.Config;

/**
 *redisson客户端构造器
 */
public abstract class RedissonClientBuilder {
    /**
     *
     * @param host
     * @param port
     * @return
     */
    public static RedissonClient createClient(String host,String port){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host+":"+port);
        return Redisson.create(config);
    }

    /**
     *
     * @param host
     * @param port
     * @return
     */
    public static RedissonReactiveClient createReactiveClient(String host,String port){
        Config config = new Config();
        config.useClusterServers().addNodeAddress("redis://"+host+":"+port);
        return Redisson.createReactive(config);
    }

    /**
     *
     * @param host
     * @param port
     * @return
     */
    public static RedissonRxClient createRxClient(String host,String port){
        Config config = new Config();
        config.useClusterServers().addNodeAddress("redis://"+host+":"+port);
        return Redisson.createRx(config);
    }


}
