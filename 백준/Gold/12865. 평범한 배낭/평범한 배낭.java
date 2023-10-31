import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		int[] dp = new int[W+1];
		int[][] bag = new int[N][2];
		int value, weight;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			weight = Integer.parseInt(str[0]);
			value = Integer.parseInt(str[1]);
			bag[i][0] = weight;
			bag[i][1] = value;
		}
		for(int o[] : bag)
			for(int i=W; i-o[0]>=0; i--)
				dp[i] = Math.max(dp[i],o[1]+dp[i-o[0]]);
		System.out.println(dp[W]);
	}
}
