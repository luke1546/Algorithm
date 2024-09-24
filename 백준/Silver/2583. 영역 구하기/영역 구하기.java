import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R,C;
	static int dirs[][] = {{-1,0}, {0,1},{1,0},{0,-1}};
	static int map[][];
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int ans = 0;
		map = new int[R][C];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			for(int j=r1; j<r2; j++) {
				for(int k=c1; k<c2; k++) {
					map[j][k] = 1;
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 0) {
					ans++;
					list.add(bfs(i,j));
				}
			}
		}
		Collections.sort(list);
		sb.append(ans).append("\n");
		for(int x : list) sb.append(x).append(" ");
		System.out.println(sb);
	}
	private static int bfs(int i, int j) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {i,j});
		map[i][j] = 1;
		int cnt = 1;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
					dq.offer(new int[] {nr,nc});
					cnt++;
					map[nr][nc] = 1;
				}
			}
		}
		return cnt;
	}
}

/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

3
1 7 13
*/
