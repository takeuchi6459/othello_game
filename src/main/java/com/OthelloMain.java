package com.example;
import main.java.com.DisplayService;

public class OthelloMain {
    public static void main(String[] args) throws InterruptedException{
        DisplayService disp = new DisplayService();

        // disp.OneLiner("Hello");

        String[][] list = new String[3][3];
        list[0][0]="1";
        list[0][1]="2";
        list[0][2]="3";
        list[1][0]="4";
        list[1][1]="5";
        list[1][2]="6";        
        list[2][0]="7";
        list[2][1]="8";
        list[2][2]="9";


        disp.BoradProt( list );
    }
}