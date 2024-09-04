package com.service;
// 8行のステータス(int)を●○形式(String[8])にデコード

public class EightArrayDecoder {
    public String[] EightArrayDecoder(int status){
        
        BordStatusDecoder bd = new BordStatusDecoder();
        String[] Line = new String[8];

        for(int i = 0; i < 8; i++){
            Line[i] = bd.BordStatusDecoder(status,i);
        }

        return Line;
    }
}
