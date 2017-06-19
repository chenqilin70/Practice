package com.huwl.oracle.springmvc.crud.handlers;

import com.huwl.oracle.springmvc.crud.dao.DepartmentDao;
import com.huwl.oracle.springmvc.crud.dao.EmployeeDao;
import com.huwl.oracle.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;


/**
 * Created by aierxuan on 2017/6/12.
 */
@Controller("employeeHandler")
public class EmployeeHandler {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

//    @ExceptionHandlerDemo({RuntimeException.class})
//    public ModelAndView handleException(Exception ex){
//        System.out.println("{exception}:"+ex.getMessage());
//        ModelAndView mv=new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }

    @ModelAttribute("employee")
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id
        ,Map<String,Object> map){
        if(id!=null){
            map.put("employee",employeeDao.getEmployee(id));
        }

    }

    @RequestMapping(value = "emp",method = RequestMethod.PUT)
    public String update( Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("depts",departmentDao.getDepartments());
        map.put("employee",employeeDao.getEmployee(id));
        return "content/input";
    }

    @RequestMapping(value = "emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        System.out.println("delete is running!!");
        return "redirect:/emps";
    }

    @RequestMapping(value="emp" , method = RequestMethod.POST)
    public String save(@Valid Employee employee, BindingResult result
            ,Map<String,Object> map){
        System.out.println(employee);
        if(result.getErrorCount()>0){
            System.out.println("出错了");
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField()+"\t--\t"+error.getDefaultMessage());
            }
            map.put("depts",departmentDao.getDepartments());
            return "/content/input";
        }
        employeeDao.save(employee);
        return "redirect:emps";
    }
    @RequestMapping(value = "emp" , method = RequestMethod.GET)
    public String input(Map map){
        map.put("depts",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "content/input";
    }

    @RequestMapping(value = "emps",method = RequestMethod.GET)
    public String list(Map map)
    {
        Collection<Employee> coll=employeeDao.getEmployees();
        map.put("emps",coll);
        return "content/list";
    }

//    @InitBinder
//    public void testInitBinder(WebDataBinder dataBinder){
//        dataBinder.setDisallowedFields("lastName");
//
//    }
}
