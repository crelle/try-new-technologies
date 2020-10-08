package crelle.test.multithread.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskPool {

    Collection<Runnable> tasks = new ArrayList<Runnable>();

    public void add(final Runnable task){
        tasks.add(task);
    }

    public  void go() throws  InterruptedException{
        System.out.println("当前可用线程数量："+Runtime.getRuntime().availableProcessors());
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try{
            final CountDownLatch countDownLatch = new CountDownLatch(tasks.size());
            for (Runnable task:tasks) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            task.run();
                        }finally {
                            countDownLatch.countDown();
                        }
                    }
                });
            }
            //等待所有的线程执行完
            countDownLatch.wait();
        }finally {
            threadPool.shutdown();
        }
    }


}
