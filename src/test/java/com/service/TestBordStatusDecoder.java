package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestBordStatusDecoder {
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void FirstTest(int s){
        BordStatusDecoder bd = new BordStatusDecoder();
        assertEquals("●", bd.BordStatusDecoder(s,7));
        // for(int i=0; i<8; i++){
        //     System.out.print(bd.BordStatusDecoder(65535,i));
        // }
    }

    // @ParameterizedTest
    // @ValueSource(ints = {1, 2, 100,})
    // public void BordTest(){
    //     EightGridBordDecoder EBD = new EightGridBordDecoder();
    //     EightGridBordDecoder(int[] n);
    // }
}
