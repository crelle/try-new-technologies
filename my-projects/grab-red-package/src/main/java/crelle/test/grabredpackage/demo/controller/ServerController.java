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
     *@author:crelle
     *@date:2020/8/20
     *@title:increaseRedPackage
     *@description:增加红包金额
     *@params:[redPackageName, num]
     *@return:void
     *@throw:
     */
    @GetMapping("/increaseRedPackage")
    public  void increaseRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num){
        grabRedPackageService.increaseRedPackage(redPackageName,num);
//        System.out.println(grabRedPackageService.getRedPackage(redPackageName));
    }

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:decreaseRedPackage
     *@description:redisson抢红包
     *@params:[redPackageName, num]
     *@return:void
     *@throw:
     */
    @GetMapping("/decreaseRedPackage")
    public  void decreaseRedPackage(@RequestParam("redPackageName") String redPackageName,@RequestParam("num") double num) throws InterruptedException {
        while (true){
            grabRedPackageService.decreaseRedPackage(redPackageName,num);
            System.out.println(grabRedPackageService.getRedPackage(redPackageName));
            Thread.sleep(1000);
        }
    }

    /**
     *@author:crelle
     *@date:2020/8/20
     *@title:grabRedPackageWithJavaSyncMethod
     *@description:s使用java同步方式抢红包
     *@params:[]
     *@return:void
     *@throw:
     */
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
