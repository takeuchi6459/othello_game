package main.java.com;

import java.util.Scanner;

public class CmdInputService {
    public void CmdInput () {
        // System.in -> キーボード入力を受け付けるための引数
        Scanner scanner = new Scanner(System.in);
        System.out.print("名前を入力してください：");
        
        // キーボード入力を受け付ける
        String name = scanner.next();
        
        System.out.println("こんにちは、" + name + "さん");
      }
}
