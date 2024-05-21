import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] dirs = {{1,1},{1,0},{1,-1}};
	static ArrayDeque<int[]> dq = new ArrayDeque<int[]>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<C; i++) dq.offer(new int[] {0,i,-1,map[0][i]});
		int min = Integer.MAX_VALUE;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			if(cur[0] == R-1) {
				min = Math.min(min, cur[3]);
				continue;
			}
			for(int i=0; i<dirs.length; i++) {
				int nr = dirs[i][0] + cur[0];
				int nc = dirs[i][1] + cur[1];
				if(nr >=0 && nr < R && nc >= 0 && nc < C && cur[2] != i) {
					dq.offer(new int[] {nr, nc, i, cur[3] + map[nr][nc]});
				}
			}
		}
		System.out.println(min);
	}
}

/*
6 4
5 8 5 1
3 5 8 4
9 77 65 5
2 1 5 2
5 98 1 5
4 95 67 58

29
*/
