import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int R, C, dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static char map[][];
	static boolean flag, visit[][];
	static ArrayDeque<int[]> fire;
	static ArrayDeque<int[]> 상근;
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];
			fire = new ArrayDeque<>();
			상근 = new ArrayDeque<>();
			for(int i=0; i<R; i++) {
				String str = br.readLine();
				for(int j=0; j<C; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == '@') {
						map[i][j] = '.';
						visit[i][j] = true;
						상근.add(new int[] {i,j});
					}
					if(map[i][j] == '*') fire.add(new int[] {i,j});
				}
			}
			int count = 0;
			flag = false;
			while(!상근.isEmpty()) {
				count++;
				spred();
				run();
				if(flag) break;
			}
			if(flag) bw.write(count+"\n");
			else bw.write("IMPOSSIBLE\n");
		}
		bw.flush();
	}
	private static void run() {
		int size = 상근.size();
		for(int i=0; i<size; i++) {
			int cur[] = 상근.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
					flag = true;
					return;
				}
				if(!visit[nr][nc] && map[nr][nc] == '.') {
					visit[nr][nc] = true;
					상근.add(new int[] {nr,nc});
				}
			}
		}
	}
	
	private static void spred() {
		int size = fire.size();
		for(int i=0; i<size; i++) {
			int cur[] = fire.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
					map[nr][nc] = '*';
					fire.add(new int[] {nr,nc});
				}
			}
		}
	}
}

/*
5
4 3
####
#*@.
####
7 6
###.###
#*#.#*#
#.....#
#.....#
#..@..#
#######
7 4
###.###
#....*#
#@....#
.######
5 5
.....
.***.
.*@*.
.***.
.....
3 3
###
#@#
###

2
5
IMPOSSIBLE
IMPOSSIBLE
IMPOSSIBLE
*/