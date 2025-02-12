import java.util.Scanner;

public class star{
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static char[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        stars(N,0,0,true);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void stars(int M,int row,int col,boolean flags){
        if(!flags){
            for(int i=0;i<M;i++){
                for(int j=0;j<M;j++){
                    print(row+i,col+j,' ');
                }
            }
            return;
        }
        if(M==1){
            print(row,col,'*');
            return;
        }
        int new_N = M/3;
        stars(new_N,row,col,true);
        stars(new_N,row,col+new_N,true);
        stars(new_N,row,col+new_N*2,true);

        stars(new_N,row+new_N,col,true);
        stars(new_N,row+new_N,col+new_N,false);
        stars(new_N,row+new_N,col+new_N*2,true);

        stars(new_N,row+new_N*2,col,true);
        stars(new_N,row+new_N*2,col+new_N,true);
        stars(new_N,row+new_N*2,col+new_N*2,true);
    }
    public static void print(int row,int col,char a){
        arr[row][col]= a;
    }
}