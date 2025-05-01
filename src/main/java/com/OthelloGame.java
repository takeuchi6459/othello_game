package com;

import java.util.Scanner;

public class OthelloGame {
    private static final int EMPTY = 0;   // 空白
    private static final int WHITE = 2;   // ○
    private static final int BLACK = 3;   // ●
    private int[][] board;               // 盤面の状態
    private int currentPlayer;           // 現在のプレイヤー（WHITE または BLACK）

    public OthelloGame() {
        board = new int[8][8];
        currentPlayer = BLACK;  // ゲームは黒から始める

        // 初期配置（中央に2つずつの石を置く）
        board[3][3] = WHITE;
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        board[4][4] = WHITE;
    }

    // 盤面を表示する
    public void displayBoard() {
        EightGridBordDecoder decoder = new EightGridBordDecoder();
        String[][] decodedBoard = decoder.EightGridBordDecoder(toStatusArray());

        DisplayService displayService = new DisplayService();
        displayService.displayProt(decodedBoard);
    }

    // 盤面をデコード用のステータス配列に変換
    private int[] toStatusArray() {
        int[] status = new int[8];
        for (int i = 0; i < 8; i++) {
            int rowStatus = 0;
            for (int j = 0; j < 8; j++) {
                rowStatus |= (board[i][j] << (14 - 2 * j));
            }
            status[i] = rowStatus;
        }
        return status;
    }

    // プレイヤーが石を置けるかチェックする
    public boolean isValidMove(int row, int col) {
        if (board[row][col] != EMPTY) return false;

        int opponent = (currentPlayer == BLACK) ? WHITE : BLACK;
        boolean valid = false;

        // 8方向を調べて挟むことができるかを確認
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr, c = col + dc;
                boolean hasOpponentBetween = false;

                while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    if (board[r][c] == opponent) {
                        hasOpponentBetween = true;
                    } else if (board[r][c] == currentPlayer && hasOpponentBetween) {
                        valid = true;
                        break;
                    } else {
                        break;
                    }
                    r += dr;
                    c += dc;
                }
            }
        }

        return valid;
    }

    // 石を置く処理
    public void placeStone(int row, int col) {
        if (!isValidMove(row, col)) {
            System.out.println("無効な手です。もう一度試してください。");
            return;
        }

        board[row][col] = currentPlayer;
        flipStones(row, col);
        currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK; // 次のプレイヤーに交代
    }

    // 石をひっくり返す処理
    private void flipStones(int row, int col) {
        int opponent = (currentPlayer == BLACK) ? WHITE : BLACK;

        // 8方向を調べて挟まれた石をひっくり返す
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int r = row + dr, c = col + dc;

                boolean hasOpponentBetween = false;
                while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    if (board[r][c] == opponent) {
                        hasOpponentBetween = true;
                    } else if (board[r][c] == currentPlayer && hasOpponentBetween) {
                        // 挟んだ石をひっくり返す
                        int rr = row + dr, cc = col + dc;
                        while (rr != r || cc != c) {
                            board[rr][cc] = currentPlayer;
                            rr += dr;
                            cc += dc;
                        }
                        break;
                    } else {
                        break;
                    }
                    r += dr;
                    c += dc;
                }
            }
        }
    }

    // プレイヤーの入力を取得
    public void playerMove() {
        Scanner scanner = new Scanner(System.in);

        int row = -1, col = -1;
        while (true) {
            System.out.printf("プレイヤー %s のターン: (行, 列) を入力してください: ", currentPlayer == BLACK ? "●" : "○");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (isValidMove(row, col)) {
                break;
            } else {
                System.out.println("無効な位置です。もう一度入力してください。");
            }
        }

        placeStone(row, col);
    }

    // ゲームを開始する
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayBoard();
            playerMove();
            System.out.println("続けますか? (y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        OthelloGame game = new OthelloGame();
        game.start();
    }
}
