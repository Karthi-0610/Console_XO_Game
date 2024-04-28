import java.util.*;
public class XOgame {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        char board[][]=new char[3][3];
        fill(board,'#');
        char player='X';
        int count=0;
        while(count<9){
            System.out.println("Enter the row:");
            int row=scan.nextInt();
            System.out.println("Enter the column:");
            int column=scan.nextInt();
            if(board[row][column]=='X' || board[row][column]=='O'){
                System.out.println("Invalid move");
            }else{
                board[row][column]=player;
                printboard(board);
                if(playerwin(board)){
                    System.out.println("player "+player+" won the game");
                    break;
                }else{
                    count++;
                }
            }
            player=(player=='X')?'O':'X';
        }
    }

    public static boolean playerwin(char[][] board){

            for(int i=0;i<3;i++){
                if((board[i][0]=='X' && board[i][1]=='X' && board[i][2]=='X') || (board[i][0]=='O' && board[i][1]=='O' && board[i][2]=='O')){
                    return true;
                }
            }

            for(int i=0;i<3;i++){
                if((board[0][i]=='X' && board[1][i]=='X' && board[2][i]=='X') || (board[0][i]=='O' && board[1][i]=='O' && board[2][i]=='O')){
                    return true;
                }
            }
            
            if((board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X') || (board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')){
                return true;
            }

            if((board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X') || (board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O')){
                return true;
            }

            return false;
    }

    public static void printboard(char[][] board){
        for(int i=0;i<3;i++){
            System.out.println("_______");
            for(int j=0;j<3;j++){
                System.out.print("|"+board[i][j]);
            }
            System.out.println();
        }
    }

    public static void fill(char[][] board,char value){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=value;
            }
        }
    }

}
