package com.demo.java;

public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 16);
        Student s2 = new Student("张三", 16, "上海一中");
        Student s3 = new Student("张三", 16, "上海一中", "计算机");
        System.out.println(s1.getName()+s1.getAge());
    }
}

class Student {
    private String name;
    private int age;
    private String school;
    private String major;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public Student(String name, int age, String school, String major) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.major = major;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
