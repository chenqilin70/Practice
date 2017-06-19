package com.huwl.oracle.springmvc.crud.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aierxuan on 2017/6/18.
 */
@ControllerAdvice
public class ExceptionHandlerDemo {
//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handleException(Exception ex){
//        System.out.println("--->{exception}:"+ex.getMessage());
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }
}
