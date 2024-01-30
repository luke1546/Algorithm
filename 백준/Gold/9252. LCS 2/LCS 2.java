import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        int R = str2.length();
        int C = str1.length();
        int[][] dp = new int[R+1][C+1];

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(str1.charAt(j-1) == str2.charAt(i-1))    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);;
            }
        }
//        for(int[] d : dp) System.out.println(Arrays.toString(d));
        int i=R, j=C;
        while(i > 0 && j>0){
            if(str1.charAt(j-1) == str2.charAt(i-1)){
                sb.append(str1.charAt(j-1));
                j--;
                i--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }
        System.out.println(dp[R][C]);
        System.out.println(sb.reverse().toString());
    }
}