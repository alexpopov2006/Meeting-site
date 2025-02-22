package com.meetingsite;

import com.meetingsite.entity.User;

public class Main {
    public static void main(String[] args) {
        var user = new User("L", 10);
        System.out.println(user);
    }

    public int f(){
        return 110;
    }
}