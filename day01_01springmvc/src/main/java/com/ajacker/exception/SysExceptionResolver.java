package com.ajacker.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ajacker
 * @date 2019/10/18 13:43
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException ex = null;
        if (e instanceof SysException) {
            ex = (SysException) e;
        } else {
            ex = new SysException("出现其它异常");
        }
        //创建ModelAndView
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
