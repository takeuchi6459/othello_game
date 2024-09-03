package main.java.com;

public class DisplayService {

    public void OneLiner(String msg){

        System.out.println( msg );

    }


    public void CarsorTest() throws InterruptedException{

        // 初期の出力
        System.out.println("Line 1: Initial text");
        System.out.println("Line 2: Initial text");
        System.out.println("Line 3: Initial text");

        // 少し待つ
        Thread.sleep(2000);

        // カーソルを上に移動
        System.out.print("\033[1A"); // カーソルを3行上に移動
        System.out.print("\033[2K"); // 現在の行をクリア

        System.out.print("\033[1A"); // カーソルを2行上に移動
        System.out.print("\033[2K"); // 現在の行をクリア

        System.out.print("\033[1A"); // カーソルを1行上に移動
        System.out.print("\033[2K"); // 現在の行をクリア

        // 新しい内容を出力
        System.out.println("Updated Line 1");
        System.out.println("Updated Line 2");
        System.out.println("Updated Line 3");

    }

    public void BoardProt( String[][] brd ){

        for (int i = 0; i < brd.length; i++) {
            for (int j = 0; j < brd[i].length; j++) {
              System.out.print(brd[i][j] + " ");
            }
            System.out.println();
          }

    }

    public void BoardUpdate( String[][] brd ){
      
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
    
}
