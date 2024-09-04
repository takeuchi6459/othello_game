package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDisplayService {
    @ParameterizedTest
    @ValueSource(strings = {"Java", "Python"})
    public void DisplayInitTest(){
        DisplayService dp = new DisplayService();
        for( int i = 0; i < 10; i++){
            String temp = dp.Testmth("Test" + i);
            assertEquals("Test" + i, temp);
        }   
    }
}
