package com.huwl.oracle.practice.test_mybatis;

import com.huwl.oracle.practice.test_mybatis.beans.Employee;
import com.huwl.oracle.practice.test_mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by aierxuan on 2017/6/19.
 */
public class TestCenter {
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
    public void helloWorld(){
        SqlSession session=factory.openSession();
        Employee employee=session.selectOne("com.huwl.oracle.mybatis.EmployeeMapper.selectEmp",1);
        System.out.println(employee);
        session.close();
    }

    @Test
    public void testInterface(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);

            System.out.println(mapper.getEmpById(1));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
