package com.service;

public class DisplayService {

    public void displayProt( String[][] brd ){

        for (int i = 0; i < brd.length; i++) {
            for (int j = 0; j < brd[i].length; j++) {
              System.out.print(brd[i][j] + " ");
            }
            System.out.println();
          }

    }

    public void DisplayUpdate( String[][] brd ){
      
        for (int i = 0; i < brd.length; i++) {
            System.out.print("\033[1A"); // カーソルを1行上に移動
            System.out.print("\033[2K"); // 現在の行をクリア
          }

        for (int i = 0; i < brd.length; i++) {
            for (int j = 0; j < brd[i].length; j++) {
              System.out.print(brd[i][j] + " ");
            }
            System.out.println();
          }
  
    }

    public void DisplayInit( int hight ){

      for (int i = 0; i < hight; i++) {
        System.out.print(""); // 空文字をセット
      }

    }

    public void DisplayClear( int hight ){

      for (int i = 0; i < hight; i++) {
        System.out.print("\033[1A"); // カーソルを1行上に移動
        System.out.print("\033[2K"); // 現在の行をクリア
      }

    }
    
}