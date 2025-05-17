import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int map[][], N, min = Integer.MAX_VALUE;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//i번 마을에서 시작
		for(int i=0; i<N; i++) {
			visit[i] = true;
			dfs(i, 1, 0, i);
			visit[i] = false;
		}
		System.out.println(min);
	}
	private static void dfs(int r, int cnt, int cost, int first) {
		if(cnt == N) {
			if(map[r][first] == 0) return;
			min = Math.min(min, cost + map[r][first]);
			return;
		}
		for(int c=0; c<N; c++) {
			if(map[r][c] == 0) continue;
			if(visit[c]) continue;
			visit[c] = true;
			dfs(c , cnt+1, cost+map[r][c], first);
			visit[c] = false;
		}
		
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