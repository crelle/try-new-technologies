package crelle.test.multithread.client;

public class HttpClientThread extends  Thread {

    private String targetURL = null;
    private String urlParameters = null;
    public HttpClientThread(String targetURL,String urlParameters) {
        this.targetURL = targetURL;
        this.urlParameters = urlParameters;
    }

    @Override
    public void run() {
        for (int i =0;i<10;i++){
        SyncHttpClient.executePost(targetURL,urlParameters+":"+i);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
