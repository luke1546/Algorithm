import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int dirs[][] = {{-1,0,0},{0,1,0},{1,0,0},{0,-1,0},{0,0,1},{0,0,-1}};
	static int F,R,C;
	static char map[][][];
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			F = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(F == 0) break;
			int start[] = new int[3];
			map = new char[R][C][F];
			for(int f=0; f<F; f++) {
				for(int i=0; i<R; i++) {
					String str = br.readLine();
					for(int j=0; j<C; j++) {
						map[i][j][f] = str.charAt(j);
						if(str.charAt(j) == 'S') {
							start[0] = i;
							start[1] = j;
							start[2] = f;
						}
					}
				}
				br.readLine();
			}
			int ans = bfs(start);
			if(ans == -1) sb.append("Trapped!\n");
			else sb.append("Escaped in ").append(ans).append(" minute(s).\n");
		}
		System.out.println(sb);
	}
	private static int bfs(int[] start) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {start[0], start[1], start[2], 0});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
//			System.out.println(Arrays.toString(cur));
			if(map[cur[0]][cur[1]][cur[2]] == 'E') return cur[3];
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				int nf = dir[2] + cur[2];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && nf >= 0 && nf < F && (map[nr][nc][nf] == '.' || map[nr][nc][nf] == 'E')) {
					dq.offer(new int[] {nr,nc,nf, cur[3]+1});
					if(map[nr][nc][nf] == '.') map[nr][nc][nf] = '#';
				}
			}
		}
		return -1;
	}
}

/*
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0


Escaped in 11 minute(s).
Trapped!
*/