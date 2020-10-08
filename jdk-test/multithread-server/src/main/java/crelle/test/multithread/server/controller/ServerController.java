package crelle.test.multithread.server.controller;

import crelle.test.multithread.server.services.WriterTaskToFile;
import crelle.test.multithread.server.services.WriterToRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class ServerController {

    @Autowired
    private WriterToRedisService writerToRedisService;

    @GetMapping("/test1")
    public  void test1(@RequestParam("num") int num) throws IOException, InterruptedException {
        WriterTaskToFile thread1 = new WriterTaskToFile(String.valueOf(num));
        thread1.start();

    }
    @PostMapping("/test2")
    public  void test2(@RequestParam("paras") String paras) throws IOException, InterruptedException {
        WriterTaskToFile thread1 = new WriterTaskToFile(paras);
        thread1.start();

    }

    @PostMapping("/redis")
    public  void writerToRedis(@RequestParam("paras") String paras) throws IOException, InterruptedException {
        writerToRedisService.insertString(paras,paras);

    }


}
