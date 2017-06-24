package com.huwl.oracle.practice.test_mvc.dao;

import com.huwl.oracle.practice.test_mvc.beans.Employee;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aierxuan on 2017/6/24.
 */

public interface EmployeeMapper {
    public List<Employee> getEmps();
}
