import java.io.*;

public class Main{
	static int dp[] = new int[13];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(factorial(n));
    }
    
    public static long factorial(int n){
    	if(dp[n] != 0) return dp[n];
        return n*factorial(n-1);
    }
}