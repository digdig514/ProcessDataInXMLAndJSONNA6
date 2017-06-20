package com.tools.application.processdatainxmlandjsonna6.model;

/**
 * Created by moh on 19/06/2017.
 */

public class Student {


    private int id;
    private String name;
    private int age;
    private float bursary;

    public Student(int id, String name, int age, float bursary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bursary = bursary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getBursary() {
        return bursary;
    }

    public void setBursary(float bursary) {
        this.bursary = bursary;
    }

    @Override
    public String toString() {
        return "Student id :"+id+
               "\nName: "+name+
               "\nAge : "+age+
               "\nBursary: "+bursary;
    }
}
