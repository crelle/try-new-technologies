package crelle.test.multithread.server.controller;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class ThreadServer {

    private long  startTime = 0;
    private long endTime = 0;

    @GetMapping("/test1")
    public  void test1(@RequestParam("num") int num) throws IOException, InterruptedException {
//      Thread1 thread1 = new Thread1(num);
//      Thread1 thread2 = new Thread1(num);
//      Thread1 thread3 = new Thread1(num);
//      thread1.start();
//      thread2.start();
//      thread3.start();

    }
    @PostMapping("/test2")
    public  void test2(@RequestParam("paras") String paras) throws IOException, InterruptedException {
        Thread1 thread1 = new Thread1(paras);
//        Thread1 thread2 = new Thread1(num);
//        Thread1 thread3 = new Thread1(num);
        thread1.start();
//      thread2.start();
//      thread3.start();

    }

}
