import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans = 0, max = 0, map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					max = Math.max(max, bfs(i,j));
					ans++;
				}
			}
		}
		System.out.println(ans);
		System.out.print(max);
	}
	private static int bfs(int i, int j) {
		int count = 0;
		visit[i][j] = true;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {i,j});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			count++;
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc] && map[nr][nc] == 1) {
					dq.offer(new int[] {nr,nc});
					visit[nr][nc] = true;
				}
			}
		}
		return count;
	}
}

/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1

4
9
*/