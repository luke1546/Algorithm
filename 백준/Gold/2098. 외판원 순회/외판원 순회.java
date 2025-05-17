import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int full = (1<<N);
        int dp[][] = new int[full][N];
        for(int row[] : dp) Arrays.fill(row, INF);
        dp[1<<0][0] = 0;
        for(int mask=0; mask<full; mask++) {
        	for(int u=0; u<N; u++) {
        		if((mask&(1<<u)) == 0 || dp[mask][u] == INF) continue;
        		for(int v=0; v<N; v++) {
        			if((mask&(1<<v)) != 0 || map[u][v] == 0) continue;
        			dp[mask|(1<<v)][v] = Math.min(dp[mask|(1<<v)][v], dp[mask][u] + map[u][v]);
        		}
        	}
        }
        
        int ans = INF;
        for(int i=0; i<N; i++) {
        	if(map[i][0] == 0) continue;
        	ans = Math.min(ans, dp[full-1][i] + map[i][0]);
        }
        System.out.println(ans);
    }
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

35
*/
