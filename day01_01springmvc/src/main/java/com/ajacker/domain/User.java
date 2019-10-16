package com.ajacker.domain;

/**
 * @author ajacker
 * @date 2019/10/16 22:05
 */
public class User {
    private String name;
    private String id;

    public User() {
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}