package crelle.test.multithread.server.services;

public interface WriterToRedisService {

    void insertString(String key,String value);

    String getString(String key);
}
