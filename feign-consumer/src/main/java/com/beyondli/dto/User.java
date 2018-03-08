package com.beyondli.dto;

/**
 * Created by beyondLi
 * Date 2018/3/1
 * Desc .
 */
public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
