package crelle.test.multithread.server.services.impl;

import crelle.test.multithread.server.dao.WriterToRedisDao;
import crelle.test.multithread.server.services.WriterToRedisService;
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
}
