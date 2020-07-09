package crelle.test.multithread.server.dao;

public interface WriterToRedisDao {

    void insertString(String key, String value);

    String getString(String key);
}
