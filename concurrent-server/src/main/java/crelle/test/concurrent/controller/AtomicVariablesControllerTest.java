package crelle.test.concurrent.controller;

import crelle.test.concurrent.services.impl.AtomicCounter;
import crelle.test.concurrent.services.impl.CommonCounter;
import crelle.test.concurrent.services.impl.SynchronizedCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@ResponseBody
public class AtomicVariablesControllerTest {

    @Autowired
    private CommonCounter commonCounter;

    @Autowired
    private SynchronizedCounter synchronizedCounter;

    @Autowired
    private AtomicCounter atomicCounter;

    @RequestMapping("/common/counter/increment")
    public void incrementCommonCounter(){
        commonCounter.increment();
    }

    @RequestMapping("/common/counter/decrement")
    public void decrementCommonCounter(){
        commonCounter.decrement();
    }

    @RequestMapping("/common/counter/value")
    public int getCommonCounterValue(){
       return commonCounter.value();
    }


    @RequestMapping("/sync/counter/increment")
    public void syncCounter(){
        synchronizedCounter.increment();
    }

    @RequestMapping("/sync/counter/decrement")
    public void decrementSyncCounter(){
        synchronizedCounter.decrement();
    }

    @RequestMapping("/sync/counter/value")
    public int getSyncCounterValue(){
        return  synchronizedCounter.value();
    }


    @RequestMapping("/atomic/counter/increment")
    public void atomicCounter(){
        atomicCounter.increment();
    }

    @RequestMapping("/atomic/counter/decrement")
    public void decrementAtomicCounter(){
        atomicCounter.decrement();
    }

    @RequestMapping("/atomic/counter/value")
    public int getAtomicCounterValue(){
        return atomicCounter.value();
    }

    @RequestMapping("/gc")
    public void gc(){
        System.gc();
    }


}
