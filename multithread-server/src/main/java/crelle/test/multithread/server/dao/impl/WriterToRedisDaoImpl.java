package crelle.test.multithread.server.dao.impl;

import crelle.test.multithread.server.common.RedissonUtils;
import crelle.test.multithread.server.dao.WriterToRedisDao;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class WriterToRedisDaoImpl implements WriterToRedisDao {

    @Autowired
    RedissonClient redissonClient;

    @Override
    public void insertString(String key, String value) {

        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(value, 30,TimeUnit.MINUTES);
    }

    @Override
    public String getString(String key) {
        return redissonClient.getBucket(key).get().toString();
    }
}
