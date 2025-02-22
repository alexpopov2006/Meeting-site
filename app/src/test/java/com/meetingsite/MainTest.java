package com.meetingsite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @DisplayName("simple test")
    @Test
    void fTest(){
        var main = new Main();
        assertEquals(10, main.f());
    }
}