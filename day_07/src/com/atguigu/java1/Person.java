package com.atguigu.java1;

public class Person {
	private String name;
	private int age;

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

	public void eat() {
		System.out.println("吃饭");
	}

    void walk() {
		System.out.println("走路");
	}
    private void sleep(){
    	
    }
}
