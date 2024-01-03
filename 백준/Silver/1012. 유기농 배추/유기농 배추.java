import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T, R, C, N, map[][];
	static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						ans++;
						dfs(i,j);
					}
				}
			}
			System.out.println(ans);
		}
	}
	private static void dfs(int i, int j) {
		for(int dir[] : dirs) {
			int nr = i + dir[0];
			int nc = j + dir[1];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				dfs(nr,nc);
			}
		}
	}
}
