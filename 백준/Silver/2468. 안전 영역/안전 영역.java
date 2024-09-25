import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		int max = 0;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k=0; k<=100; k++) {
			visit = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>k && !visit[i][j]) {
						dfs(i,j,k);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	private static void dfs(int i, int j, int k) {
		visit[i][j] = true;
		for(int dir[] : dirs) {
			int nr = i+dir[0];
			int nc = j+dir[1];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > k && !visit[nr][nc]) {
				dfs(nr,nc,k);
			}
		}
	}
}

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7

5
*/