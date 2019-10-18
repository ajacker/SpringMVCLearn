package com.ajacker.controller;

import com.ajacker.domain.Account;
import com.ajacker.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header) {
        System.out.println("执行了...");
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("执行了...");
        System.out.println(cookie);
        return "success";
    }
//    @ModelAttribute
//    public void searchUser(Map<String,Object> map,@RequestParam("name") String name){
//        User user = new User();
//        user.setName(name);
//        user.setId("xxx");
//        System.out.println(user);
//        map.put("user1", user);
//    }

//    @ModelAttribute
//    public User searchUser(@RequestParam("name") String name){
//        User user = new User();
//        user.setName(name);
//        user.setId("xxx");
//        System.out.println(user);
//        return user;
//    }

    @ModelAttribute("result")
    @RequestMapping("/testModelAttribute")
    public User testModelAttribute(String name) {
        User user = new User();
        user.setName(name);
        user.setId("xxx");
        System.out.println(user);
        return user;
    }

    @RequestMapping("/testModelAttribute2")
    public User testModelAttribute2(@ModelAttribute("result") User user) {
        System.out.println(user);
        return user;
    }
}
