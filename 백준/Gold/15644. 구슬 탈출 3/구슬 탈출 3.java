import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int R,C, dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static char[][] map;
	static int hole = 0;
	static ArrayDeque<int[]> ball = new ArrayDeque<int[]>();
	static HashMap<String, Boolean> visit = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sbDir = new StringBuilder();
		HashMap<Integer, String> iToS = new HashMap<>();
		iToS.put(0, "U");
		iToS.put(1, "R");
		iToS.put(2, "D");
		iToS.put(3, "L");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		
		
		
		int s[] = new int[4];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<C; j++)	{
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					s[0] = i;
					s[1] = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'B') {
					s[2] = i;
					s[3] = j;
					map[i][j] = '.';
				}
			}
		}
		ball.offer(new int[] {s[0],s[1],s[2],s[3],0,0,0,0});
		int[] answer = bfs();
		System.out.println(answer[0]);
		for(int i=0; i<answer[0]; i++) {
			sbDir.append(iToS.get(answer[1]%4));
			answer[1]/=4;
		}
		System.out.println(sbDir.reverse().toString());
	}

	private static int[] bfs() {
		while(!ball.isEmpty()) {
			int cur[] = ball.poll();
			for(int i=0; i<4; i++)	sb.append(cur[i]);
			if(visit.containsKey(sb.toString()))	continue;
			visit.put(sb.toString(), true);
			sb = new StringBuilder();
			if(cur[5] == 1)	continue;
			else if(cur[4] == 1) return new int[] {cur[6], cur[7]};
			if(cur[6] > 10) return new int[] {-1,-1};
			for(int i=0; i<4; i++) {
				go(cur,i);
			}
		}
		return new int[] {-1,-1};
	}

	private static void go(int cur[], int d) {
		int r[] = new int[] {cur[0],cur[1]};
		int b[] = new int[] {cur[2],cur[3]};
		int rHole = cur[4];
		int bHole = cur[5];
		map[b[0]][b[1]] = 'B';
		r = move(r,d);
		
		if(r[0] != -1)	map[r[0]][r[1]] = 'R';
		
		map[b[0]][b[1]] = '.';
		b = move(b,d);
		
		if(b[0] != -1)	map[b[0]][b[1]] = 'B';
		
		if(r[0] != -1) {
			map[r[0]][r[1]] = '.';
			r = move(r,d);
		}
		
		if(b[0] != -1)	map[b[0]][b[1]] = '.';
		if(r[0] == -1)	rHole = 1;
		if(b[0] == -1)	bHole = 1;
		
		ball.offer(new int[] {r[0], r[1], b[0], b[1], rHole, bHole, cur[6]+1, cur[7]*4+d});
	}

	private static int[] move(int cur[], int dir) {
		while(true) {
			int nr = dirs[dir][0] + cur[0];
			int nc = dirs[dir][1] + cur[1];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
				cur[0] = nr;
				cur[1] = nc;
			}
			else if(map[nr][nc] == 'O') {
				return new int[] {-1,-1};
			}
			else	break;
		}
		return cur;
	}
}
