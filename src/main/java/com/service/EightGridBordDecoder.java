package com.service;
// 8行のステータス(int[8])を●○形式(String[8][8])にデコード

public class EightGridBordDecoder {
    public String[][] EightGridBordDecoder(int status[]){

        EightArrayDecoder ed = new EightArrayDecoder();
        String[][] StoneData = new String[8][8];

        for(int i = 0; i < 8; i++){

            StoneData[i] = ed.EightArrayDecoder(status[i]);

        }
        return StoneData;
    }
}
