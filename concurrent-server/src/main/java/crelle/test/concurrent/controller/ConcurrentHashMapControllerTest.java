package crelle.test.concurrent.controller;

import crelle.test.concurrent.services.impl.HashMapMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@ResponseBody
public class ConcurrentHashMapControllerTest {

    @Autowired
    private HashMapMaper hashMapMaper;

    @RequestMapping("/hashmap/push")
    public void hashMapPush(){
        hashMapMaper.push();
    }

    @RequestMapping("/hashmap/modify")
    public void hashMapModify(){
         hashMapMaper.modify();
    }

    @RequestMapping("/hashmap/size")
    public int hashMapSize(){
        return hashMapMaper.size();
    }
    @RequestMapping("/hashmap/issuccess")
    public String hashMapIsSuccess(){
        return hashMapMaper.isSuccess();
    }


}
