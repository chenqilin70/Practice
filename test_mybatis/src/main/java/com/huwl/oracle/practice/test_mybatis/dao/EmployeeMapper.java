package com.huwl.oracle.practice.test_mybatis.dao;

import com.huwl.oracle.practice.test_mybatis.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public boolean delEmp(Integer id);

    public void updateEmp(Employee employee);

    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);

    public Employee getEmpByMap(Map<String,Object> map);
}
