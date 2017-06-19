package com.huwl.oracle.springmvc.crud.handlers;

import com.huwl.oracle.springmvc.crud.dao.EmployeeDao;
import com.huwl.oracle.springmvc.crud.entities.Employee;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * Created by aierxuan on 2017/6/15.
 */
@Controller
public class SpringMVCTest {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "^^username is not right")
    @RequestMapping("/testResponseStatusExceptionHandler")
    public String testResponseStatusExceptionHandler(@RequestParam("i") Integer i){
        if(i==13){
            throw new MyException();
        }
        System.out.println("testResponseStatusExceptionHandler is running");
        return "success" ;
    }

//    @ExceptionHandlerDemo({RuntimeException.class})
//    public ModelAndView handleException(Exception ex){
//        System.out.println("{exception}:"+ex.getMessage());
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }
//
//
//
//    @ExceptionHandlerDemo({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception ex){
//        System.out.println("exception:"+ex.getMessage());
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") Integer i){
        System.out.println("result"+(10/i));
        return "success";
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc")String desc
            , @RequestParam("testFile")MultipartFile file){
        System.out.println(desc);
        System.out.println(file.getOriginalFilename());
        try {
            System.out.println(file.getInputStream());
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("D:/tempFile/aaa.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        System.out.println(locale);
        String val=messageSource.getMessage("i18n.user",null,locale);
        System.out.println(val);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session){
        ServletContext context=session.getServletContext();
        InputStream in=context.getResourceAsStream("/files/1.txt");
        byte[] body=null;
        try {
            body=new byte[in.available()];
            in.read(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=1.txt");

        HttpStatus statusCode=HttpStatus.OK;

        ResponseEntity<byte[]> entity=new ResponseEntity<byte[]>(body,headers,statusCode);
        return entity;
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getEmployees();
    }

    @RequestMapping("/testConversionService")
    public String testConver(@RequestParam("employee")Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ResponseBody
    @RequestMapping("testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "helloWorld! "+new Date();
    }
}
