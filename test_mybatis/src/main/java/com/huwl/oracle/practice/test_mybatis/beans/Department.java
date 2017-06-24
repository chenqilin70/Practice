package com.huwl.oracle.practice.test_mybatis.beans;

import com.sun.xml.internal.ws.encoding.soap.SerializerConstants;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aierxuan on 2017/6/21.
 */
public class Department implements Serializable{
    private Integer id;
    private String departmentName;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department() {}
}
