package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBordStatusDecoder {
    
    @Test
    public void FirstTest(){
        BordStatusDecoder bd = new BordStatusDecoder();
        assertEquals("●", bd.BordStatusDecoder(65535,2));
        // for(int i=0; i<8; i++){
        //     System.out.print(bd.BordStatusDecoder(65535,i));
        // }
    }

    @Test
    public void BordTest(){
        EightGridBordDecoder EBD = new EightGridBordDecoder();
        
    }
}
