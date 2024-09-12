package com.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestEightArrayDecoder {
    
    /**
     * @param ex
     * @param s
     */
    @ParameterizedTest
    @CsvSource({
     "[' ',' ',' ',' ',' ',' ',' ',' '], 0",
     "' , , , , , , , ', 1",
     "' , , , , , , ,○', 2",
     "' , , , , , , ,●', 3",

     "' , , , , , , , ', 0",
     "' , , , , , , , ', 4",
     "' , , , , , , ,○', 8",
     "' , , , , , , ,●', 12"

    })

    public void ArrayTest(String[] ex, int s){
        EightArrayDecoder dc = new EightArrayDecoder();
        assertArrayEquals(ex, dc.EightArrayDecoder(s));
    }

    @DisplayName("Should rotate successfully")
    @ParameterizedTest()
    @CsvSource({
            "'[1, 0, 0]', '[1, 0, 0]'",
    })
    void givenAnArrayAndAShiftSize_ShouldSuccesfullyRotateOrReturnFalse(String arrayStr, String expectedArrayStr) {

        var window = Arrays.asList(arrayStr.replace("[", "").replace("]", "").split(","))
                .stream()
                .mapToLong(c -> Long.parseLong(c.toString().trim()))
                .toArray();

        String[] window_st = Arrays.stream(window)
                .mapToObj(Long::toString)  // longをStringに変換
                .toArray(String[]::new);  // String[]に収集


        var result = Arrays.asList(expectedArrayStr.replace("[", "").replace("]", "").split(","))
                .stream()
                .mapToLong(c -> Long.parseLong(c.toString().trim()))
                .toArray();

        String[] result_st = Arrays.stream(result)
                .mapToObj(Long::toString)  // longをStringに変換
                .toArray(String[]::new);  // String[]に収集

        // System.out.println(Arrays.toString(window_st));
        // System.out.println(Arrays.toString(result_st));
        assertArrayEquals(result_st, window_st);
        
    }

}




