package com.ajacker.controller;

import com.ajacker.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ajacker
 * @date 2019/10/16 11:54
 */
@Controller
@RequestMapping("/account")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello springmvc!");
        return "success";
    }

    @RequestMapping("/findAccount/{id}")
    public String findAccount(@PathVariable("id") int accountId) {
        System.out.println("accountId:" + accountId);
        return "success";
    }


    @RequestMapping("/updateAccount")
    public String findAccount(Account account) {
        System.out.println("account:" + account);
        return "success";
    }

    @RequestMapping("/path")
    public void myHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getParameter("param1"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("操作成功");
    }


    @RequestMapping("/testAjax")
    @ResponseBody
    public Account testAjax(@RequestBody Account account) {

        System.out.println(account);

        // 将user对象返回给前端页面
        return account;
    }
}
