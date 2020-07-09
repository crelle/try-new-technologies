package crelle.test.grabredpackage.demo.services.impl;


import crelle.test.grabredpackage.demo.dao.WriterToRedisDao;
import crelle.test.grabredpackage.demo.services.WriterToRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterToRedisServiceImpl implements WriterToRedisService {

    @Autowired
    private WriterToRedisDao writerToRedisDao;

    @Override
    public void insertString(String key, String value) {
        writerToRedisDao.insertString(key,value);
    }

    @Override
    public String getString(String key) {
        return writerToRedisDao.getString(key);
    }

    @Override
    public void createRedPackage(String redPackageName, double balance) {
        writerToRedisDao.createRedPackage(redPackageName,balance);
    }

    @Override
    public void deleteRedPackage(String redPackageName) {
        writerToRedisDao.deleteRedPackage(redPackageName);
    }

    @Override
    public void increaseRedPackage(String redPackageName, double num) {
        writerToRedisDao.increaseRedPackage(redPackageName,num);
    }

    @Override
    public void decreaseRedPackage(String redPackageName, double num) {
        writerToRedisDao.decreaseRedPackage(redPackageName,num);
    }


}
