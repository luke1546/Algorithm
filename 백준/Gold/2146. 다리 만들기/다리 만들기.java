import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int cnt=1, N, min = Integer.MAX_VALUE, map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visit[][];
	static ArrayDeque<int[]> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		cnt = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == cnt) {
					visit = new boolean[N][N];
					큐장전(i,j);
					다리연결();
					cnt++;
				}
			}
		}
		
		System.out.println(min);
	}
	private static void 큐장전(int i, int j) {
		visit[i][j] = true;
		queue.add(new int[] {i,j,0});
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {i,j});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc] != 0) {
					visit[nr][nc] = true;
					queue.add(new int[] {nr,nc,0});
					dq.offer(new int[] {nr,nc});
				}
			}
		}
	}
	private static void 다리연결() {
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			if(map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != cnt) {
				min = Math.min(min, cur[2]-1);
				queue.clear();
				break;
			}
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
					visit[nr][nc] = true;
					queue.offer(new int[] {nr, nc, cur[2]+1});
				}
			}
		}
	}
	private static void bfs(int i, int j) {
		visit[i][j] = true;
		map[i][j] = cnt;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {i,j});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc] != 0) {
					visit[nr][nc] = true;
					map[nr][nc] = cnt;
					dq.offer(new int[] {nr,nc});
				}
			}
		}
	}
}
