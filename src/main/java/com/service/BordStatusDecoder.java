package com.service;

public class BordStatusDecoder {

    public String BordStatusDecoder(int status, int grid){

        return StringExcanger(GridStatusDecoder(status, grid));

    }

    private String StringExcanger(int status_code){
        switch(status_code){
            case 2:
                return "○";
            case 3:
                return "●";
        }
        return " ";
    }

    private int GridStatusDecoder(int status, int grid){
        
        return status >> (14 - 2 * grid) & 3;

    }
}
