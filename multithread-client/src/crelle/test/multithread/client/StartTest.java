package crelle.test.multithread.client;

import java.util.UUID;

public class StartTest {
    public static void main(String[] args) {
        for (int i = 0;i<1000;i++){
            String random = UUID.randomUUID().toString();
            HttpClientThread httpClientThread = new HttpClientThread("http://localhost:8080/test2","paras="+random);
            httpClientThread.start();
        }
    }
}
