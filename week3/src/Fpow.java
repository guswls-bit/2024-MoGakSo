import java.util.Scanner;

public class Fpow{
    static int C;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A,B;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        System.out.print(calc(A,B)%C);
    }
    public static long calc(int A, int B){
        if(B==1) return A%C;
        if(B%2==0){
            long x = calc(A,B/2)%C;
            return x*x%C;
        }
        else{
            long x = calc(A,(B-1)/2)%C;
            return (x%C*x%C)*A%C;
        }
    }
}