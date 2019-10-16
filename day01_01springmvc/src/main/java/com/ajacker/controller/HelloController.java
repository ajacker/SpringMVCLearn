package com.ajacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ajacker
 * @date 2019/10/16 11:54
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello springmvc!");
        return "success";
    }
}
