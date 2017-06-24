package com.huwl.oracle.practice.test_mvc.controller;

import com.huwl.oracle.practice.test_mvc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by aierxuan on 2017/6/24.
 */
@Controller
public class EmpController {
    @Autowired
private EmpService empService;
    @RequestMapping("emps")
    public String getEmps(Map<String, Object> map){
        map.put("emps",empService.getEmps());
        return "list";
    }
}
