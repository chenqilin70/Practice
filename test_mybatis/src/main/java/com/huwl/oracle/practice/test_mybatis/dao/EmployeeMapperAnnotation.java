package com.huwl.oracle.practice.test_mybatis.dao;

import com.huwl.oracle.practice.test_mybatis.beans.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * Created by aierxuan on 2017/6/20.
 */
public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id = #{id}" )
    public Employee getEmpById(Integer id);
}
