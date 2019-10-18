package com.ajacker.controller;

import com.ajacker.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ajacker
 * @date 2019/10/18 13:38
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException" + "执行了");

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("出现系统异常");
        }
        return "success";
    }
}
