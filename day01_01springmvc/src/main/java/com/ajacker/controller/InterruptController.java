package com.ajacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ajacker
 * @date 2019/10/18 20:40
 */
@Controller
@RequestMapping("/interrupt")
public class InterruptController {

    @RequestMapping("/testInterrupter")
    public String testInterrupter() {
        System.out.println("控制器中的方法执行了");
        return "success";
    }
}
