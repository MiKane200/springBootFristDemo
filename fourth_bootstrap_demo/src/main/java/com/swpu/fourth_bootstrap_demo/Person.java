package com.swpu.fourth_bootstrap_demo;

public class Person {
    private String uname;
    private Integer age;
    private String address;

    public Person() {
        super();
    }

    public Person(String name, Integer age, String address) {
        this.uname = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return uname;
    }

    public void setName(String name) {
        this.uname = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
