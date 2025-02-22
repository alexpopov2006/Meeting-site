package com.meetingsite.entity;

public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return """
                User{name = %s; age = %d}""".formatted(name, age);
    }
}
