package com.service;

import javax.print.DocPrintJob;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestDisplayService {
    @ParameterizedTest
    @CsvSource({
        "'[1, 0, 0]', '[1, 0, 1]', '[1, 0, 1]'"
})
    public void DisplayInitTest( String arr ){

        // シングルクォートと空白を除去し、カンマで分割
        String[] rows = arr.replace("'", "").split(",\\s*");

        // 2次元配列への変換
        String[][] disp_String_arr = Arrays.stream(rows)
                .map(row -> row.replaceAll("[\\[\\]]", "").split(","))
                .toArray(String[][]::new);

        DisplayService dp = new DisplayService();
        
        dp.DisplayInit(10);

        // Thread.sleep(1000);

        dp.displayProt(disp_String_arr);

        // Thread.sleep(1000);

        // dp.DisplayClear(10);
    }



}
