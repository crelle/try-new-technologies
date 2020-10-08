package crelle.test.redis.redisson.redpackage;

import org.redisson.api.RLock;

public interface GrabRedPackageService {

    void addString(String key, String value);

    String getString(String key);

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:createRedPackage
     *@description:创建红包
     *@params:[redPackageName, balance]
     *@return:void
     *@throw:
     */
    void createRedPackage(String redPackageName, double balance);

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:deleteRedPackage
     *@description:删除红包
     *@params:[redPackageName]
     *@return:void
     *@throw:
     */
    void deleteRedPackage(String redPackageName);

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:increaseRedPackage
     *@description:增加红包金额
     *@params:[redPackageName, num]
     *@return:void
     *@throw:
     */
    void increaseRedPackage(String redPackageName, double num);

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:decreaseRedPackage
     *@description:减少红包金额
     *@params:[redPackageName, num]
     *@return:void
     *@throw:
     */
    void decreaseRedPackage(String redPackageName, double num);

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:getRedPackage
     *@description:获取红包
     *@params:[redPackageName]
     *@return:java.lang.String
     *@throw:
     */
    String getRedPackage(String redPackageName);

    RLock getLock(String lockName);

    void grabRedPackageWithJavaSync(String redPackageName,double money);

}
