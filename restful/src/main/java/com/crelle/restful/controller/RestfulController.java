package com.crelle.restful.controller;

import com.crelle.restful.model.ReponseBean;
import com.crelle.restful.model.RequestBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @ProjectName try-new-technologies
 * @ClassName RestfulController
 * @Description TODO
 * @Author crelle
 * @Date 2020/5/11 10:19
 * @Version 1.0
 **/
@RestController
@RequestMapping("/rest")
public class RestfulController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("home");
    }

    @GetMapping
    public ReponseBean get(RequestBean requestbean) {

        return new ReponseBean();
    }

    @PostMapping
    public ReponseBean post(RequestBean requestBean){
        return new ReponseBean();
    }

    @DeleteMapping
    public ReponseBean delete(RequestBean requestBean){

        return null;
    }
}
