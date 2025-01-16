import java.util.Scanner;

public class Main {
    static int weight = 500;
    public static int[] arr;
    public static boolean[] visit;
    public static int count=0;
    public static void main(String[] args){
        int N,K;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        check(N,K,0);
    }
    public static int check(int N,int K,int depth){
        
    }
}
