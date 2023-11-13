import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max = 0, map[][], dp[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dp = new int[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++)
				map[i][j] = (str.charAt(j)-'0');
		}
		boolean visit[][] = new boolean[R][C];
		dfs(0,0,1,visit);
		visit[0][0] = true;
		System.out.println(max);
	}
	private static void dfs(int i, int j, int k, boolean[][] visit) {
		if(map[i][j] == 24)	return;
		if(max != -1)	max = Math.max(max, k);
		dp[i][j] = k;
		int X = map[i][j];
		for(int dir[] : dirs) {
			int nr = i + dir[0] * X;
			int nc = j + dir[1] * X;
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(visit[nr][nc]) {
					max = -1;
					return;
				}
				if(dp[nr][nc] > k) continue;
				visit[nr][nc] = true;
				dfs(nr,nc,k+1,visit);
				visit[nr][nc] = false;
			}
		}
	}
}
