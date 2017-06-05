package com.huwl.oracle.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aierxuan on 2017/6/5.
 */
@Controller
public class HelloWorld {
    @RequestMapping("helloworld")
    public String hello(){
        System.out.println("hello world!!");
        return "success";
    }
}
