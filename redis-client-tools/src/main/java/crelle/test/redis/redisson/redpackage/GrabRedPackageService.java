package crelle.test.redis.redisson.redpackage;

import org.redisson.api.RLock;

public interface GrabRedPackageService {

    void addString(String key, String value);

    String getString(String key);

    /**
     * 创建红包
     * @param redPackageName
     * @param balance
     */
    void createRedPackage(String redPackageName, double balance);

    /**
     * 删除红包
     * @param redPackageName
     */
    void deleteRedPackage(String redPackageName);

    void increaseRedPackage(String redPackageName, double num);

    void decreaseRedPackage(String redPackageName, double num);

    RLock getLock(String lockName);

    void grabRedPackageWithJavaSync(String redPackageName,double money);

}
