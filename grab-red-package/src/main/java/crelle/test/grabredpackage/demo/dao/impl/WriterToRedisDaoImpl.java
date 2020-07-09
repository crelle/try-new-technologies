package crelle.test.grabredpackage.demo.dao.impl;


import crelle.test.grabredpackage.demo.dao.WriterToRedisDao;
import org.redisson.api.RAtomicDouble;
import org.redisson.api.RBucket;
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

    @Override
    public void createRedPackage(String redPackageName, double balance) {
        RAtomicDouble redPackage = redissonClient.getAtomicDouble(redPackageName);
        redPackage.set(balance);
    }

    @Override
    public void deleteRedPackage(String redPackageName) {
            redissonClient.getAtomicDouble(redPackageName).delete();
    }

    @Override
    public void increaseRedPackage(String redPackageName, double num) {
        double old =   redissonClient.getAtomicDouble(redPackageName).get();
        redissonClient.getAtomicDouble(redPackageName).set(old+num);
    }

    @Override
    public void decreaseRedPackage(String redPackageName, double num) {
      double old =   redissonClient.getAtomicDouble(redPackageName).get();
      redissonClient.getAtomicDouble(redPackageName).set(old-num);
    }


}
