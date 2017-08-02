package com.huwl.oracle;

/**
 * Created by aierxuan on 2017/8/2.
 */
public class Student {
    private Integer stuId;
    private String name;
    private Integer age;

    public Integer getStuId() {
        return stuId;
    }

    public Student setStuId(Integer stuId) {
        this.stuId = stuId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }
}
