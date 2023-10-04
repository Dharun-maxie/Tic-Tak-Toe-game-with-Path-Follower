package Game.TikTacToc;

import java.util.*;

public class Main {
    static int row=3,col=3;

    public static void main(String[] args) {
        Queue<int[]> PX=new ArrayDeque<>();
        Queue<int[]> PY=new ArrayDeque<>();
        Scanner put = new Scanner(System.in);
        System.out.println("TikTacToc Game");
        char[][] board = new char[row][col];
        boolean winner=false;
        CreateBoard(board);
        while(!winner) {
            PrintBoard(board);
            System.out.println("Player X is Turn");
            System.out.println("Player X Enter the position to place piece:");
            int r = put.nextInt();
            int c = put.nextInt();
            PX.add(new int[] {r,c});
            board[r][c] = 'X';
            PrintBoard(board);
            if (Winner(board, 'X')) {
                System.out.println("Player X is the Winner");
                System.out.print("Player x PATH --->");
                while(!PX.isEmpty())
                {
                    System.out.print(Arrays.toString(PX.peek()) +" ");
                    PX.remove();
                }
                return;
            }
                System.out.println("Player O is Turn");
                System.out.println("Player O Enter the position to place piece:");
                int r1 = put.nextInt();
                int c1 = put.nextInt();
                PY.add(new int[] {r1,c1});
                board[r1][c1] = 'O';
            if (Winner(board, 'O')) {
                System.out.println("Player O is the Winner");
                System.out.print("Player O PATH --->");
                while(!PY.isEmpty())
                {
                    System.out.print(Arrays.toString(PY.peek()) +" ");
                    PY.remove();
                }
                winner=Winner(board, 'O');
            }
        }
    }

    static boolean Winner(char[][] board,char ch) {
        //Diagonal
        if(board[0][0]==ch && board[1][1]==ch && board[2][2]==ch){
            return true;
        }
        else if(board[2][0]==ch && board[1][1]==ch && board[0][2]==ch)
        {
            return true;
        }
        //row
        else if(board[0][0]==ch && board[0][1]==ch && board[0][2]==ch)
        {
            return true;
        }
        else if(board[1][0]==ch && board[1][1]==ch && board[1][2]==ch)
        {
            return true;
        }
        else if(board[2][0]==ch && board[2][1]==ch && board[2][2]==ch)
        {
            return true;
        }
        //col
        else if(board[0][0]==ch && board[1][0]==ch && board[2][0]==ch)
        {
            return true;
        }
        else if(board[0][1]==ch && board[1][1]==ch && board[2][1]==ch) {
            return true;
        }
        else return board[0][2] == ch && board[1][2] == ch && board[2][2] == ch;
    }
    static void CreateBoard(char[][] board)
    {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j]=' ';
            }
        }
    }
    static void PrintBoard(char[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ch=board[i][j];
                System.out.print(ch +" |");
            }
            System.out.println();
        }
    }
}
