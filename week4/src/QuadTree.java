import java.util.Scanner;

public class QuadTree {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            String[] strArr = sc.next().split("");
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        parti(N,0,0);
        System.out.println(sb);
    }
    public static void parti(int N,int row,int col){
        if(check(N,row,col)){
            sb.append((int)arr[row][col]);
            return;
        }
        if(N==1){
            sb.append((int)arr[row][col]);
            return;
        }
        int newN = N/2;
        sb.append('(');
        parti(newN,row,col);
        parti(newN,row,col+newN);

        parti(newN,row+newN,col);
        parti(newN,row+newN,col+newN);
        sb.append(')');

    }
    public static boolean check(int N,int row,int col){
        for(int i=row;i<N+row;i++){
            for(int j=col;j<N+col;j++){
                if(arr[row][col]!=arr[i][j]) return false;
            }
        }
        return true;
    }
}
