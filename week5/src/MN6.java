import java.util.Scanner;

public class MN6 {
    public static Boolean[] visited;
    public static int[] path;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N,M;
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new Boolean[N];
        path = new int[M];
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=N-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                }
            }
        }
        for(int i=0;i<N;i++){
            visited[i] = false;
        }
        travel(N,M,0);
        System.out.println(sb);
    }
    public static void travel(int N,int M,int idx){
        if(M==0){
            for(int i=0;i<idx;i++){
                sb.append(path[i]);
                sb.append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0;i<N;i++){
            if(visited[i])
                continue;
            if (idx != 0 && path[idx-1]>arr[i])continue;
            visited[i] = true;
            path[idx] = arr[i];
            travel(N,M-1,idx+1);
            visited[i] = false;
        }
    }
}