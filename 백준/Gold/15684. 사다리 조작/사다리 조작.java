import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C, ans=4, LR[][] = {{0,-1},{0,0},{0,1}};
	static boolean map[][];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = true;
		}
		dfs(0,0,0);
		System.out.println(ans==4? -1 : ans);
	}
	private static void dfs(int r, int c, int cnt) {
		if(cnt == 4) return;
		if(check()) {
			ans = Math.min(ans, cnt);
			return;
		}
		for(int i=r; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(canInstall(i,j)) {
					map[i][j] = true;
					dfs(i,j, cnt+1);
					map[i][j] = false;
				}
			}
		}
	}
	private static boolean canInstall(int i, int j) {
		for(int dir[] : LR) {
			int nr = i + dir[0];
			int nc = j + dir[1];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(map[nr][nc]) return false;
			}
		}
		return true;
	}
	private static boolean check() {
		for(int j=0; j<C; j++) {
			int start = j;
			for(int i=0; i<R; i++) {
				if(start != C && map[i][start])
					start++;
				else if(start != 0 && map[i][start-1])
					start--;
			}
			if(start != j) return false;
		}
		return true;
	}
}

/*
5 5 6
1 1
3 2
2 3
5 1
5 4

3
*/