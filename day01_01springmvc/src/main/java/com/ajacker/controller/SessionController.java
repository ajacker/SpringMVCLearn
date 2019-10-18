package com.ajacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author ajacker
 * @date 2019/10/18 12:42
 */
@Controller
@RequestMapping("session")
@SessionAttributes({"username", "password", "age"})
public class SessionController {
    @RequestMapping("/testPut")
    public String testPut(Model model) {
        model.addAttribute("username", "泰斯特");
        model.addAttribute("password", "123456");
        model.addAttribute("age", 31);
        //跳转之前将数据保存到 username、password 和 age 中，因为注解@SessionAttribute 中有 这几个参数
        return "success";
    }

    @RequestMapping("/testGet")
    public String testGet(ModelMap model) {
        System.out.println(model.get("username") + ";" + model.get("password") + ";" + model.get("age"));
        return "success";
    }

    @RequestMapping("/testClean")
    public String complete(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "success";
    }
}
