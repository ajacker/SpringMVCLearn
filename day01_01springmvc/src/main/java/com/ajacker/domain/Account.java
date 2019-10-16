package com.ajacker.domain;

import java.io.Serializable;

/**
 * @author ajacker
 * @date 2019/10/16 20:29
 */
public class Account implements Serializable {
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
