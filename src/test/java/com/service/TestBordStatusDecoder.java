package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestBordStatusDecoder {
    
    @ParameterizedTest
    @CsvSource({
     "' ', 0",
     "' ', 1",
     "○, 2",
     "●, 3"
    })
    public void FirstTest(String ex, int s){
        BordStatusDecoder bd = new BordStatusDecoder();
        assertEquals(ex, bd.BordStatusDecoder(s,7));
    }

    // @ParameterizedTest
    // @ValueSource(ints = {1, 2, 100,})
    // public void BordTest(){
    //     EightGridBordDecoder EBD = new EightGridBordDecoder();
    //     EightGridBordDecoder(int[] n);
    // }
}
