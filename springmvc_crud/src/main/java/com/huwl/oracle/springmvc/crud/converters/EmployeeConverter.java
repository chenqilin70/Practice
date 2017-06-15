package com.huwl.oracle.springmvc.crud.converters;

import com.huwl.oracle.springmvc.crud.entities.Department;
import com.huwl.oracle.springmvc.crud.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by aierxuan on 2017/6/15.
 */
@Component
public class EmployeeConverter implements Converter<String,Employee>{

    public Employee convert(String s) {
        if(s!=null){
            String[] values=s.split("-");
            //GG-gg@atguigu.com-true-108
            if(values!=null && values.length==4){
                String lastName=values[0];
                String email=values[1];
                Boolean gender=Boolean.parseBoolean(values[2]);
                Department department=new Department();
                department.setId(Integer.parseInt(values[3]));
                Employee employee=new Employee(null,lastName,email,gender,department);
                System.out.println(s+"--"+employee);
                return employee;
            }
        }
        return null;
    }
}
