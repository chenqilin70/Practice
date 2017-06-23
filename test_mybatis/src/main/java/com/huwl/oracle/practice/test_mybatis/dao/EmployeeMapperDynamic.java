package com.huwl.oracle.practice.test_mybatis.dao;

import com.huwl.oracle.practice.test_mybatis.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by aierxuan on 2017/6/22.
 */
public interface EmployeeMapperDynamic {
    public List<Employee> getEmpsByConditioinIf(Employee employee);
    public List<Employee> getEmpsByConditioinTrim(Employee employee);
    public List<Employee> getEmpsByConditioinChoose(Employee employee);
    public void updateEmp(Employee employee);
    public List<Employee> getEmpsByIdForeach( List<Integer> ids);
    public void addEmps(List<Employee> emps);
    public List<Employee> getEmpsUseBind(Employee employee);
}
