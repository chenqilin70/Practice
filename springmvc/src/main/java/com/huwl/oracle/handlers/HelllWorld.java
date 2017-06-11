package com.huwl.oracle.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aierxuan on 2017/6/6.
 */
@Controller
public class HelllWorld {
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world!!");
        return "success";
    }
}
