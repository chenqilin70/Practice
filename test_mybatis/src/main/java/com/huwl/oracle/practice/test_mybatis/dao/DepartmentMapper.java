package com.huwl.oracle.practice.test_mybatis.dao;

import com.huwl.oracle.practice.test_mybatis.beans.Department;

/**
 * Created by aierxuan on 2017/6/21.
 */
public interface DepartmentMapper {

    public Department getDeptById(Integer id);
}
