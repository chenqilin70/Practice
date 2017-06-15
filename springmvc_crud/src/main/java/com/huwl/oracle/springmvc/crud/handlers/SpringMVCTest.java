package com.huwl.oracle.springmvc.crud.handlers;

import com.huwl.oracle.springmvc.crud.dao.EmployeeDao;
import com.huwl.oracle.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by aierxuan on 2017/6/15.
 */
@Controller
public class SpringMVCTest {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping("/testConversionService")
    public String testConver(@RequestParam("employee")Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
