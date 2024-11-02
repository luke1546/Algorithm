import java.io.*;
public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.print(factorial(n));
    }
    public static long factorial(long x){
        if(x == 0 || x==1) return 1;
        return factorial(x-1) * x;
    }
}