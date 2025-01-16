import java.util.Scanner;

public class Prob2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int R,C,N;
        R=scan.nextInt();
        C=scan.nextInt();
        N=scan.nextInt();
        char[][] bomb1 = new char[R][C];
        char[][] bomb2 = new char[R][C];
        char[][] bomb3 = new char[R][C];
        for(int i=0;i<R;i++)
            bomb1[i] = scan.next().toCharArray();
        for(int i=0;i<R;i++) {
            for (int j = 0; j < C; j++) {
                bomb2[i][j] = 'O';
            }
        }
        bomb3 = calc(R,C,bomb1);
        if(N==1){
            printGrid(bomb1);
        }
        else if(N%2==0){
            printGrid(bomb2);
        }
        else if(N%4==3){
            printGrid(bomb3);
        }
        else{
            printGrid(bomb1);
        }
    }
    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

    private static char[][] calc(int R,int C, char[][] grid){
        char[][] result= new char[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                result[i][j] = 'O';
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i - 1][j] = '.';
                    if (i < R - 1) result[i + 1][j] = '.';
                    if (j > 0) result[i][j - 1] = '.';
                    if (j < C - 1) result[i][j + 1] = '.';
                }
            }
        }
        return result;
    }

}