import java.util.Scanner;

public class Paper {
    public static int[] count = new int[2];
    public static int[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        count[0] = 0;
        count[1] = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        parti(N,0,0);
        System.out.println(count[0]);
        System.out.println(count[1]);
    }
    public static void parti(int N,int row,int col){
        if(N==1) {
            count[arr[row][col]]++;
            return;
        }
        if(check(N,row,col)){
            count[arr[row][col]]++;
            return;
        }
        int newN = N/2;
        parti(newN,row,col);
        parti(newN,row,col+newN);

        parti(newN,row+newN,col);
        parti(newN,row+newN,col+newN);
    }
    public static boolean check(int N,int row,int col){
        int base = arr[row][col];
        for(int i=row;i<N+row;i++){
            for(int j=col;j<N+col;j++){
                if(arr[i][j] != base){
                    return false;
                }
            }
        }
        return true;
    }
}
