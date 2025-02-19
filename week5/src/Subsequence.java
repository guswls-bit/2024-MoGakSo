import java.util.Scanner;

public class Subsequence{
    public static Boolean[] visited;
    public static int[] arr;
    public static int[] path;
    public static int count=0;
    public static int S,sum=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        S = sc.nextInt();
        visited = new Boolean[N];
        arr = new int[N];
        path = new int[N];
        for(int i=0;i<N;i++){
            visited[i] = false;
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<N;i++) {
            travel(N, i+1,0);
        }
        System.out.println(count);
    }
    public static void travel(int N,int M,int idx){
        if(M==0){
            if(sum==S) count++;
            return;
        }
        for(int i=idx;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            sum += arr[i];
            travel(N,M-1,i+1);
            sum -= arr[i];
            visited[i] = false;
        }

    }
}