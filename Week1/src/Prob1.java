import java.util.Scanner;

public class Prob1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int H,W,X,Y;
        H = scan.nextInt();
        W = scan.nextInt();
        X = scan.nextInt();
        Y = scan.nextInt();
        int[][] arr = new int[H+X][W+Y];
        int[][] origin = new int[H][W];
        //기존 배열 [0~H-1][0~W-1]
        //+X +Y한 배열 [X~H-1+X][Y~W-1+Y]
        for(int i=0;i<H+X;i++){
            for(int j=0;j<W+Y;j++){
                arr[i][j]=scan.nextInt();
            }
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(i==0 || j==0) origin[i][j]=arr[i][j];
                else if(i>=X&&j>=Y){
                    origin[i][j] = arr[i][j]-origin[i-X][j-Y];
                }
                else origin[i][j] = arr[i][j];
                System.out.printf("%d ",origin[i][j]);
            }
            System.out.print("\n");
        }
    }
}