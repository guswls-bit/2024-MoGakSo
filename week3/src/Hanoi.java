import java.util.Scanner;

public class Hanoi {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sb.append((int) (Math.pow(2,N)-1)).append('\n');
        HanoiTower(N,'1','2','3');
        System.out.println(sb);
    }
    public static void HanoiTower(int N,char from,char dest, char by){
        if(N==1){
            sb.append(from+" "+by+"\n");
        }
        else{
            HanoiTower(N-1,from,by,dest);
            sb.append(from+" "+by+"\n");
            HanoiTower(N-1,dest,from,by);
        }
    }
}
