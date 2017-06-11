package com.huwl.oracle.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by aierxuan on 2017/6/11.
 */
@SessionAttributes(value = {"name"},types = {Integer.class})
@Controller
public class Hander11 {
    @ModelAttribute
    public void getUser(@RequestParam(value="username",required = false) String username,Map map){
        System.out.println("ModelAttribute is running");
        User userFromDB=new User();
        userFromDB.setUsername(username);
        userFromDB.setAge(12);
        Address address=new Address();
        address.setProvince("hubei ");
        address.setCity("wuhan");
        userFromDB.setAddress(address);
        map.put("user",userFromDB);
    }
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改之后的user为："+user);
        return "success";
    }

    @RequestMapping("testSession")
    public String testSession(Map map){
        map.put("name","kylinChen");
        map.put("age",12);
        return "success";
    }
    @RequestMapping("testMap")
    public String testMap(Map map){
        map.put("name","klylinlin");
        map.put("age",12);
        return "success";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(HttpServletRequest request){
        request.setAttribute("age","12");
        ModelAndView modelAndView=new ModelAndView("success");
        modelAndView.addObject("name","kylin");
        return modelAndView;
    }

    @RequestMapping("testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("testPOJO")
    public String testPOJO(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String sessionid){
        System.out.print(sessionid);

         return "success";
    }

    @RequestMapping(value = "testRequestHeader/{id}")
    public String testRequestHeader(@PathVariable("id") String id
            , @RequestHeader(value = "User-Agent",required = false,defaultValue = "no browser") String header){
        System.out.println(id+"-->header:"+header);
        return "success";
    }

    @RequestMapping(value = "testParam",params = {"aaa","bbb"})
    public String testParam(@RequestParam Integer aaa,@RequestParam Boolean bbb){
        System.out.println("testParam+"+(aaa+1)+"\t"+bbb);
        return "success";
    }
}
