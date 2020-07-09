package crelle.test.grabredpackage.demo.controller;

import crelle.test.grabredpackage.demo.services.WriterToRedisService;
import crelle.test.multithread.server.services.WriterTaskToFile;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class ServerController {

    private long  startTime = 0;
    private long endTime = 0;

    @Autowired
    private WriterToRedisService writerToRedisService;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/test1")
    public  void test1(@RequestParam("num") int num) throws IOException, InterruptedException {
        WriterTaskToFile thread1 = new WriterTaskToFile(String.valueOf(num));
        thread1.start();

    }
    @PostMapping("/test2")
    public  void test2(@RequestParam("paras") String paras) throws IOException, InterruptedException {
        WriterTaskToFile thread1 = new WriterTaskToFile(paras);
//        Thread1 thread2 = new Thread1(num);
//        Thread1 thread3 = new Thread1(num);
        thread1.start();
//      thread2.start();
//      thread3.start();

    }

    @PostMapping("/redis")
    public  void writerToRedis(@RequestParam("paras") String paras) throws IOException, InterruptedException {
        writerToRedisService.insertString(paras,paras);
    }

    @GetMapping("/createRedPackage")
    public void createRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("balance") double balance){
        writerToRedisService.createRedPackage(redPackageName,balance);
    }

    @GetMapping("/deleteRedPackage")
    public void deleteRedPackage(@RequestParam("redPackageName") String redPackageName){
        writerToRedisService.deleteRedPackage(redPackageName);
    }

    /**
     *
     * @param redPackageName
     * @param num
     */
    @GetMapping("/increaseRedPackage")
    public  void increaseRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
        writerToRedisService.increaseRedPackage(redPackageName,num);
    }

    /**
     * 抢红包
     * @param redPackageName
     * @param num
     */
    @GetMapping("/decreaseRedPackage")
    public  void decreaseRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
        writerToRedisService.decreaseRedPackage(redPackageName,num);
    }

    /**
     * 抢红包
     * @param redPackageName
     * @param num
     */
    @GetMapping("/decreaseRedPackageWithLock")
    public  void decreaseRedPackageWithLock(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
            RLock rLock = redissonClient.getLock("redPackageLock");
        try {

            rLock.lock(1000*5, TimeUnit.MILLISECONDS);
            writerToRedisService.decreaseRedPackage(redPackageName,num);

        }finally {
            rLock.unlock();
        }
    }


}
