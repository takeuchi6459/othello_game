package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestDisplayService {
    @ParameterizedTest
    @ValueSource(strings = {"Java", "Python"})
    public void DisplayInitTest(String s){
        DisplayService dp = new DisplayService();
        System.out.println("Value Source " + s + " test");
        String temp = dp.Testmth(s);
        assertEquals("Java", temp);

    }
}
