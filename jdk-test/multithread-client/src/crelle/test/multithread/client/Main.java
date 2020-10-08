package crelle.test.multithread.client;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskPool taskPool = new TaskPool();
        for (int i = 0;i<4;i++){
            HttpPostTask postTask = new HttpPostTask("http://localhost:8080/test2","paras=key"+i);
            HttpGetTask getTask = new HttpGetTask("https://www.zfsphp.com/",null);
            taskPool.add(getTask);
        }
        taskPool.go();
    }
}
