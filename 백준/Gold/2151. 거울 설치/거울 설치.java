import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int ans=0, N, dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static char map[][];
	static boolean end = false;
	static Deque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '#') {
					if(dq.isEmpty())	{
						map[i][j] = '*';
						for(int d=0; d<4; d++) {
							int nr = i + dirs[d][0];
							int nc = j + dirs[d][1];
							if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != '*') {
								dq.offer(new int[] {i, j, d, 0});
							}
						}
					}
				}
			}
		}
		while(!end)	move(dq.poll());
		System.out.println(ans);
	}
	private static void move(int[] cur) {
		while(true) {
			int nr = cur[0] + dirs[cur[2]][0];
			int nc = cur[1] + dirs[cur[2]][1];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N)	break;
			if(map[nr][nc] == '*')	break;
			if(map[nr][nc] == '#') {
				end = true;
				ans = cur[3];
				break;
			}
			if(map[nr][nc] == '!') {
				int d1 = cur[2] -1, d2 = cur[2] + 1;
				if(cur[2] == 0) d1 = 3;
				if(cur[2] == 3) d2 = 0;
				dq.offer(new int[] {nr, nc, d1, cur[3]+1});
				dq.offer(new int[] {nr, nc, d2, cur[3]+1});
			}
			cur[0] = nr;
			cur[1] = nc;
		}
	}
}

/*
7
.!..!.#
*.....*
.!..!..
..*....
.*!..*.
....!..
.*#****
*/