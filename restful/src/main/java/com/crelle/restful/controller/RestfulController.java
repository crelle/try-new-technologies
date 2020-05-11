package com.crelle.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
public class RestfulController {

    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        request.setAttribute("name", name);
            return modelAndView;
    }
}
