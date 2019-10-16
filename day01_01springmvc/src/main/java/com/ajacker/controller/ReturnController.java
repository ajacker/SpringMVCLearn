package com.ajacker.controller;

import com.ajacker.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ajacker
 * @date 2019/10/16 22:04
 */
@Controller
@RequestMapping("/return")
public class ReturnController {


    /**
     * 返回String
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        // 执行方法体...向隐式对象添加属性attribute_user,可以在jsp中通过 ${attribute_user} 获取到
        model.addAttribute("attribute_user", new User("张三", "123"));
        // 经过视图解析器的处理,SpringMVC会将请求转发到/WEB-INF/pages/succeess.jsp,但浏览器地址栏显示的一直是 项目域名/user/testString
        return "success";
    }

    /**
     * 无返回值
     *
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 执行方法体...向隐式对象添加属性attribute_user,可以在jsp中通过 ${attribute_user} 获取到
        model.addAttribute("attribute_user", new User("张三", "123"));

        // 通过下面三个方法之一,可以指定访问的视图
        // 指定视图的方式1: 请求转发
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 指定视图的方式2: 重定向
        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 指定视图的方式3: 通过Writer对象写入内容
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");

    }

    /**
     * 返回模型视图
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {

        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        // 向model中存入属性attribute_user
        mv.addObject("attribute_user", new User("张三", "123"));

        // 指定返回视图,视图解析器将"success"解析为视图URL /WEB-INF/pages/succeess.jsp
        mv.setViewName("success");
        return mv;
    }

    /**
     * 测试转发
     *
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward() {
        // 在forward:要写完整的相对路径
        // return "forward:success"	// 错误,会将请求转发到 /项目名/user/success
        return "forward:/WEB-INF/pages/success.jsp";
    }

    /**
     * 测试重定向
     *
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        // 在forward:要写完整的相对路径
        // return "redirect:" + request.getContextPath() + "/index.jsp";	// 错误,会将请求转发到 /项目名/index.jsp
        return "redirect:/index.jsp";
    }
}
