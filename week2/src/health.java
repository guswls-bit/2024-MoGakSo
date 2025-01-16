import java.util.Scanner;

public class health {
    static int weight = 500;
    public static int[] arr;
    public static boolean[] visit;
    public static int count=0;
    static int N,K;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        visit = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        check(500,0);
        System.out.println(count);
    }
    public static void check(int x,int y){
        if(x<500) return ;
        if(y==N) {
            count++;
            return;
        }
        x -= K;
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                check(x+arr[i],y+1);
                visit[i] = false;
            }
        }

    }
}
