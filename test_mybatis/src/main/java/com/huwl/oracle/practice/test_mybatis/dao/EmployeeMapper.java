package com.huwl.oracle.practice.test_mybatis.dao;

import com.huwl.oracle.practice.test_mybatis.beans.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}
