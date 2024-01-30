import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int R = str2.length();
        int C = str1.length();
        int[][] dp = new int[R+1][C+1];

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(str1.charAt(j-1) == str2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);;
                }
            }
        }
        System.out.println(dp[R][C]);
    }
}