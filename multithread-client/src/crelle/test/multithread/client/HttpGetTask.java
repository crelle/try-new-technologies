package crelle.test.multithread.client;

public class HttpGetTask implements  Runnable {


    private String targetURL;
    private String urlParameters;

    public HttpGetTask(String targetURL, String urlParameters) {
        this.targetURL = targetURL;
        this.urlParameters = urlParameters;
    }

    @Override
    public void run() {
        for (int i =0;i<1000;i++){
            SyncHttpClient.executeGet(targetURL);
            System.out.println(i+"-"+Thread.currentThread().getName());
        }
        System.out.println("key"+urlParameters+".执行结束！");
    }
}
