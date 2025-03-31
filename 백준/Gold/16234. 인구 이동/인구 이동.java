import java.io.*;
import java.util.*;

public class Main {
	static int map[][], N, dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int L, H;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while(checkUnion()) {
			cnt++;
		}
		System.out.println(cnt);
//		for(int m[] : map) {
//			for(int n : m) System.out.print(n + " ");
//			System.out.println();
//		}
	}
	
	public static boolean checkUnion() {
		boolean visit[][] = new boolean[N][N];
		boolean flag = true;
		int unionMap[][] = new int[N][N];
		int unionSum[] = new int[N*N+1];
		int cnt = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) 
					bfs(i,j, cnt++, visit, unionMap, unionSum);
			}
		}
		if(cnt == N*N+1) flag = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = unionSum[unionMap[i][j]];
			}
		}
		return flag;
	}

	private static void bfs(int i, int j, int cnt, boolean[][] visit, int[][] unionMap, int[] unionSum) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {i,j});
		visit[i][j] = true;
		unionMap[i][j] = cnt;
		unionSum[cnt] += map[i][j];
		int max = 1;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && getDiff(map[cur[0]][cur[1]], map[nr][nc])) {
					dq.offer(new int[] {nr,nc});
					visit[nr][nc] = true;
					unionMap[nr][nc] = cnt;
					unionSum[cnt] += map[nr][nc];
					max++;
				}
			}
		}
		unionSum[cnt]/= max;
	}

	private static boolean getDiff(int i, int j) {
		int diff = Math.abs(i-j);
		if(diff >= L && diff <= H) return true;
		return false;
	}
}

/*
2 20 50
50 30
30 40

1
*/