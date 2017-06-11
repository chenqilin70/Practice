package com.huwl.oracle.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aierxuan on 2017/6/6.
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS="success";
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("/testRequestMapping");
        return SUCCESS;
    }
    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }
    @RequestMapping(value = "/testParamsAndHeads",params = {"username","age!=10"},headers = "Accept-Language=zh-CN,zh;q=0.6,en;q=0.4,es;q=0.2")
    public String testParamsAndHeads(){

        return SUCCESS;
    }
    @RequestMapping("/testAntPath/1?2/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return SUCCESS;
    }
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable:"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("testRest get:"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("testRest delete:"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRest PUT:"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest post:");
        return SUCCESS;
    }
}
