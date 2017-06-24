package com.huwl.oracle.practice.test_mybatis;

import com.huwl.oracle.practice.test_mybatis.beans.Department;
import com.huwl.oracle.practice.test_mybatis.beans.Employee;
import com.huwl.oracle.practice.test_mybatis.dao.DepartmentMapper;
import com.huwl.oracle.practice.test_mybatis.dao.EmployeeMapper;
import com.huwl.oracle.practice.test_mybatis.dao.EmployeeMapperAnnotation;
import com.huwl.oracle.practice.test_mybatis.dao.EmployeeMapperDynamic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aierxuan on 2017/6/19.
 */
public class TestCacheCenter {
    private SqlSessionFactory factory;
    @Before
    public void before(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            System.out.println(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testSecondLevelCache(){
        SqlSession session1=factory.openSession();
        SqlSession session2=factory.openSession();
        try{
            EmployeeMapper mapper1=session1.getMapper(EmployeeMapper.class);
            Employee employee1= mapper1.getEmpById(1);
            System.out.println(employee1);
            session1.close();
            EmployeeMapper mapper2=session2.getMapper(EmployeeMapper.class);
            Employee employee2= mapper2.getEmpById(1);
            System.out.println(employee2);
            session2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testFirstLevelCache(){
        SqlSession session1=factory.openSession();
//        SqlSession session2=factory.openSession();
        try{
            EmployeeMapper mapper1=session1.getMapper(EmployeeMapper.class);
            Employee employee1= mapper1.getEmpById(1);
            System.out.println(employee1);

//            mapper1.addEmp(new Employee("mike","mike@qq.com","0"));
            session1.clearCache();

            Employee employee2= mapper1.getEmpById(1);
            System.out.println(employee2);
//            EmployeeMapper mapper2=session2.getMapper(EmployeeMapper.class);
//            Employee employee2= mapper2.getEmpById(1);
//            System.out.println(employee2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session1.close();
        }
    }

}
