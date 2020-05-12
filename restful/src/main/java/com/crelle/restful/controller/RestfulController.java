package com.crelle.restful.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

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
    public ModelAndView get(HttpServletRequest request, Model model) {
        ModelAndView modelAndView = new ModelAndView("home::getMapping");
        modelAndView.addObject("name","this is http method is get!");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView("home::getMapping");
        modelAndView.addObject("name","this is http method is get!");
        return modelAndView;
    }
}
