package com.example.auto_test;

import java.util.List;

public class Student {
    private String fullName;
    private Integer age;
    private List<String> courses;

    Student(String fullName,Integer age){
        this.fullName=fullName;
        this.age=age;
    }

    public Student() {
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
    public Integer getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age=age;
    }
    public List<String> getCourses() {
        return courses;
    }
}
