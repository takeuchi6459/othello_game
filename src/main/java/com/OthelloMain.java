package com;
import com.service.CmdInputService;
import com.service.DisplayService;

public class OthelloMain {
    /**
     * @param args
     * @throws InterruptedException
     */
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
        disp.BoardProt( list );

        // 少し待つ
        Thread.sleep(1000);


        for(int i=0;i < 10;i++){

            list[0][0]="a";
            list[0][1]="b";
            list[0][2]="c";
            list[1][0]="d";
            list[1][1]="e";
            list[1][2]="f";        
            list[2][0]="g";
            list[2][1]="h";
            list[2][2]="i";
            disp.BoardUpdate( list );

            // 少し待つ
            Thread.sleep(1000);

            list[0][0]="1";
            list[0][1]="2";
            list[0][2]="3";
            list[1][0]="4";
            list[1][1]="5";
            list[1][2]="6";        
            list[2][0]="7";
            list[2][1]="8";
            list[2][2]="9";
            disp.BoardUpdate( list );
    
            // 少し待つ
            Thread.sleep(1000);
            
        }

        CmdInputService cmd = new CmdInputService();
        cmd.CmdInput();

    }
}