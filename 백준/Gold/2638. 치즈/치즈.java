import java.util.*;
import java.io.*;

public class Main {
	static int R, C, ans = 0, map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visit[][];
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) dq.offer(new int[] {i,j});
				map[i][j] = x;
			}
		}
		edge();
		air();
		while(!dq.isEmpty()) {
			ans++;
			air();
			melt();
//			print();
		}
		System.out.println(ans);
	}
	private static void melt() {
		int size = dq.size();
		for(int i=0; i<size; i++) {
			int cur[] = dq.poll();
			int cnt = 0;
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 2)
					cnt++;
			}
			if(cnt < 2) dq.offer(new int[] {cur[0], cur[1]});
			else map[cur[0]][cur[1]] = 0;
		}
	}
	private static void air() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 2) pollution(i,j);
			}
		}
	}
	private static void pollution(int i, int j) {
		ArrayDeque<int[]> bfs = new ArrayDeque<>();
		bfs.offer(new int[] {i,j});
		while(!bfs.isEmpty()) {
			int cur[] = bfs.poll();
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
					bfs.offer(new int[] {nr,nc});
					map[nr][nc] = 2;
				}
			}
		}
	}
	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	private static void edge() {
		for(int i=0; i<R; i++) map[i][0] = 2;
		for(int i=0; i<R; i++) map[i][C-1] = 2;
		for(int j=0; j<C; j++) map[0][j] = 2;
		for(int j=0; j<C; j++) map[R-1][j] = 2;
	}
}


/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

4
*/