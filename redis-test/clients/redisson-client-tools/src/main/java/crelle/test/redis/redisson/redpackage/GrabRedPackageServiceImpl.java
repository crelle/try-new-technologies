package crelle.test.redis.redisson.redpackage;


import crelle.test.redis.redisson.RedissonClientBuilder;
import org.redisson.api.RAtomicDouble;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;


import java.util.concurrent.TimeUnit;


public class GrabRedPackageServiceImpl   implements GrabRedPackageService {

    RedissonClient redissonClient = null;

    public GrabRedPackageServiceImpl(String host, String port) {
        redissonClient =  RedissonClientBuilder.createClusterClient(host,port,null,"123456");
    }


    /**
     * 添加一个字符串
     * @param key
     * @param value
     */
    @Override
    public void addString(String key, String value) {

        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(value, 30,TimeUnit.MINUTES);
    }

    /**
     * 获取一个字符串
     * @param key
     * @return
     */
    @Override
    public String getString(String key) {
        return redissonClient.getBucket(key).get().toString();
    }

    /**
     *创建红包
     * @param redPackageName 红包名字
     * @param balance 红包金额
     */
    @Override
    public void createRedPackage(String redPackageName, double balance) {
        RAtomicDouble redPackage = redissonClient.getAtomicDouble(redPackageName);
        redPackage.set(balance);
    }

    /**
     *删除红包
     * @param redPackageName 红包名字
     */
    @Override
    public void deleteRedPackage(String redPackageName) {
            redissonClient.getAtomicDouble(redPackageName).delete();
    }

    /**
     *增加红包金额
     * @param redPackageName 红包名字
     * @param money 金额
     */
    @Override
    public void increaseRedPackage(String redPackageName, double money) {
        RLock rlock = getLock("redPackageLock");
        try{
            rlock.lock(1000*5, TimeUnit.MILLISECONDS);
            double old =   redissonClient.getAtomicDouble(redPackageName).get();
            redissonClient.getAtomicDouble(redPackageName).set(old+money);
        }finally {
            rlock.unlock();
        }
    }

    /**
     * 减少红包金额
     * @param redPackageName 红包名字
     * @param money 金额
     */
    @Override
    public void decreaseRedPackage(String redPackageName, double money) {
          RLock rlock = getLock("redPackageLock");
          try{
              rlock.lock(1000*5, TimeUnit.MILLISECONDS);
              double old =   redissonClient.getAtomicDouble(redPackageName).get();
              redissonClient.getAtomicDouble(redPackageName).set(old-money);
          }finally {
              rlock.unlock();
          }
    }

    @Override
    public String getRedPackage(String redPackageName) {
        return redissonClient.getAtomicDouble(redPackageName).toString();
    }


    @Override
    public RLock getLock(String lockName) {
        return redissonClient.getLock(lockName);
    }

    @Override
    public void grabRedPackageWithJavaSync(String redPackageName, double money) {

    }
}
