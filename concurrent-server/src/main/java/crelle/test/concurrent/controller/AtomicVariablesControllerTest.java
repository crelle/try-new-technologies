package crelle.test.concurrent.controller;

import crelle.test.concurrent.services.impl.AtomicCounter;
import crelle.test.concurrent.services.impl.CommonCounter;
import crelle.test.concurrent.services.impl.SynchronizedCounter;
import crelle.test.concurrent.services.impl.VolatileCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@ResponseBody
@Scope(value = "prototype")
public class AtomicVariablesControllerTest {

    @Autowired
    private CommonCounter commonCounter;

    @Autowired
    private SynchronizedCounter synchronizedCounter;

    @Autowired
    private AtomicCounter atomicCounter;

    @Autowired
    private VolatileCounter volatileCounter;

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
    @Scope(value = "prototype")
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

    @RequestMapping("/volatile/counter/increment")
    public void volatileCounter(){
        volatileCounter.increment();
    }

    @RequestMapping("/volatile/counter/decrement")
    public void decrementVolatileCounter(){
        volatileCounter.decrement();
    }

    @RequestMapping("/volatile/counter/value")
    public int getVolatileCounterValue(){
        return volatileCounter.value();
    }

    @RequestMapping("/gc")
    public void gc(){
        System.gc();
    }


}
