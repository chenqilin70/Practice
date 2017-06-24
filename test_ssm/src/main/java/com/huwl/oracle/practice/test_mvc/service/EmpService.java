package com.huwl.oracle.practice.test_mvc.service;

import com.huwl.oracle.practice.test_mvc.beans.Employee;
import com.huwl.oracle.practice.test_mvc.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aierxuan on 2017/6/24.
 */
@Service
public class EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getEmps() {
        System.out.println(employeeMapper);
        return null;
//        return employeeMapper.getEmps();
    }
}
