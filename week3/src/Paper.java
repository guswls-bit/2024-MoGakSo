import java.util.Scanner;

public class Paper {
    public static int[][] arr;
    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        parti(0,0,N);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

    }
    public static void parti(int row, int col, int size){
        if(check(row,col,size)){
            if(arr[row][col]==-1) count1++;
            else if(arr[row][col]==0) count2++;
            else count3++;
            return;
        }
        int newSize = size/3;

        parti(row,col,newSize);
        parti(row,col+newSize,newSize);
        parti(row,col+newSize*2,newSize);

        parti(row+newSize,col,newSize);
        parti(row+newSize,col+newSize,newSize);
        parti(row+newSize,col+newSize*2,newSize);

        parti(row+newSize*2,col,newSize);
        parti(row+newSize*2,col+newSize,newSize);
        parti(row+newSize*2,col+newSize*2,newSize);
    }
    public static boolean check(int row, int col, int size){
        int color = arr[row][col];

        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(color != arr[i][j]) return false;
            }
        }
        return true;
    }
}
