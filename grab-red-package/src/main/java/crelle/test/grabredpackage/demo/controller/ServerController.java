package crelle.test.grabredpackage.demo.controller;

import crelle.test.redis.redisson.redpackage.GrabRedPackageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ServerController {
    private  double redPackage = 100000;

    private GrabRedPackageServiceImpl grabRedPackageService  = null;

    public ServerController (){
        grabRedPackageService  = new GrabRedPackageServiceImpl("192.168.74.3","6379");
    }



    @GetMapping("/createRedPackage")
    public void createRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("balance") double balance){
        grabRedPackageService.createRedPackage(redPackageName,balance);
    }

    @GetMapping("/deleteRedPackage")
    public void deleteRedPackage(@RequestParam("redPackageName") String redPackageName){
        grabRedPackageService.deleteRedPackage(redPackageName);
    }

    /**
     *
     * @param redPackageName
     * @param num
     */
    @GetMapping("/increaseRedPackage")
    public  void increaseRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
        grabRedPackageService.increaseRedPackage(redPackageName,num);
    }

    /**
     * 抢红包
     * @param redPackageName
     * @param num
     */
    @GetMapping("/decreaseRedPackage")
    public  void decreaseRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
        grabRedPackageService.decreaseRedPackage(redPackageName,num);
    }

    /**
     * 使用reidisson lock抢红包
     * @param redPackageName
     * @param num
     */
    @GetMapping("/decreaseRedPackageWithLock")
    public  void decreaseRedPackageWithLock(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
            grabRedPackageService.decreaseRedPackage(redPackageName,num);
    }

    @GetMapping("grabRedPackageWithJavaSyncMethod")
    public void grabRedPackageWithJavaSyncMethod(){
        decrement();
        System.out.println(Thread.currentThread().getName()+"          "+redPackage);
    }

    private synchronized void increment(){
        redPackage++;
    }
    private  synchronized void decrement(){
        redPackage--;
    }


}
