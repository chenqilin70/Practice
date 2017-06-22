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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testAnnotationSelect(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapperAnnotation mapper=session.getMapper(EmployeeMapperAnnotation.class);
            System.out.println(mapper.getEmpById(1)+"-->");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testAdd(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            Employee employee=new Employee("Jerry",null,"0");
            mapper.addEmp(employee);
            System.out.println("生成的主键为："+employee.getId());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testUpdate(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            mapper.updateEmp(new Employee(1,"TomDing","TomDing@qq.com","1"));
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testDelte(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            boolean result=mapper.delEmp(100);
            System.out.println("result:"+result);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testMultParam(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpByIdAndLastName(5,"kylin2");
            System.out.println(employee);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testMapParam(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            Map map=new HashMap();
            map.put("id",5);
            map.put("lastName","kylin2");
            Employee employee=mapper.getEmpByMap(map);
            System.out.println(employee);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void testDifEmp(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpAndDept(1);
            System.out.println(employee);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testDeptById(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            DepartmentMapper mapper=session.getMapper(DepartmentMapper.class);
            Department department=mapper.getDeptById(1);
            System.out.println(department);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testGetEmpByStep(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpByStep(1);
            System.out.println(employee.getDept().getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testCollection(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            DepartmentMapper mapper=session.getMapper(DepartmentMapper.class);
            Department department=mapper.getDeptByIdPlus(2);
            System.out.println(department.getEmployees().size());
            for(Employee e : department.getEmployees()){
                System.out.println(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testGetEmpsByDeptId(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            List<Employee> emps=mapper.getEmpsByDeptId(2);
            System.out.println(emps);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testCollectionStep(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            DepartmentMapper mapper=session.getMapper(DepartmentMapper.class);
            Department department=mapper.getDeptByIdStep(2);
            System.out.println(department.getEmployees().size());
            for(Employee e : department.getEmployees()){
                System.out.println(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testGetEmpByIdDis(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapper mapper=session.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmpByIdDis(5);
            System.out.println(employee);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testDynamicSqlIf(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapperDynamic mapper=session.getMapper(EmployeeMapperDynamic.class);
            List<Employee> emps=mapper.getEmpsByConditioinIf(new Employee(null,"%tom%","  ",null));
            System.out.println(emps);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testDynamicSqlTrim(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapperDynamic mapper=session.getMapper(EmployeeMapperDynamic.class);
            List<Employee> emps=mapper.getEmpsByConditioinTrim(new Employee(null,"%tom%","  ",null));
            System.out.println(emps);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void testDynamicSqlChoose(){
        SqlSession session=null;
        try{
            session=factory.openSession();
            EmployeeMapperDynamic mapper=session.getMapper(EmployeeMapperDynamic.class);
            List<Employee> emps=mapper.getEmpsByConditioinChoose(new Employee(1,"%tom%",null,null));
            System.out.println(emps);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
