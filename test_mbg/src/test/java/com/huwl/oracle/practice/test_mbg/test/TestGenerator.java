package com.huwl.oracle.practice.test_mbg.test;

import com.huwl.oracle.practice.test_mbg.bean.Employee;
import com.huwl.oracle.practice.test_mbg.bean.EmployeeExample;
import com.huwl.oracle.practice.test_mbg.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aierxuan on 2017/6/25.
 */
public class TestGenerator {
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
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    @Test
    public void testDifMybatis(){
        SqlSession session=factory.openSession();
        try {
            EmployeeExample employeeExample=new EmployeeExample();
            EmployeeExample.Criteria criteria1=employeeExample.createCriteria();
            criteria1.andGenderEqualTo("0");
            criteria1.andDIdIsNotNull();
            EmployeeExample.Criteria criteria2=employeeExample.createCriteria();
            criteria2.andLastNameLike("%1%");

            employeeExample.or(criteria2);

            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);

            List<Employee> list=mapper.selectByExample(employeeExample);
            for(Employee e:list){
                System.out.println(e.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
