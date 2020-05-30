package com.crelle.restful.controller;

import com.crelle.restful.model.ReponseBean;
import com.crelle.restful.model.RequestBean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;



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
    
    /**
     * @Description 演示@GetMapping用法
     * @Param: [model]
     * @Return: java.lang.String
     * @Author: crelle
     * @Date: 2020/5/15 15:43
     */
    @GetMapping(path = "/")
    public String get(Model model) {
        model.addAttribute("name","this http method is get!");
        return "getMapping";
    }

    /**
     * @Description 演示PathVariable用法
     * @Param: [model, id]
     * @Return: java.lang.String
     * @Author: crelle
     * @Date: 2020/5/15 15:44
     */
    @GetMapping("/{id}")
    public String get(Model model,@PathVariable(name = "id") String id){
        return null;
    }


    @GetMapping("/{id,name}")
    public String get(Map<String,String> map) {
        return null;
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
