package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestBordStatusDecoder {
    
    @ParameterizedTest
    @CsvSource({
     "' ', 0, 7",
     "' ', 1, 7",
     "○, 2, 7",
     "●, 3, 7",

     "' ', 0, 6",
     "' ', 4, 6",
     "○, 8, 6",
     "●, 12, 6",

     "' ', 0, 5",
     "' ', 16, 5",
     "○, 32, 5",
     "●, 48, 5",

     "' ', 0, 4",
     "' ', 64, 4",
     "○, 128, 4",
     "●, 192, 4",

     "' ', 0, 3",
     "' ', 256, 3",
     "○, 512, 3",
     "●, 768, 3",

     "' ', 0, 2",
     "' ', 1024, 2",
     "○, 2048, 2",
     "●, 3072, 2",

     "' ', 0, 1",
     "' ', 4096, 1",
     "○, 8192, 1",
     "●, 12288, 1",

     "' ', 0, 0",
     "' ', 16384, 0",
     "○, 32768, 0",
     "●, 49152, 0"
    })
    public void FirstTest(String ex, int s, int g){
        BordStatusDecoder bd = new BordStatusDecoder();
        assertEquals(ex, bd.BordStatusDecoder(s,g));
    }

    // @ParameterizedTest
    // @ValueSource(ints = {1, 2, 100,})
    // public void BordTest(){
    //     EightGridBordDecoder EBD = new EightGridBordDecoder();
    //     EightGridBordDecoder(int[] n);
    // }
}
