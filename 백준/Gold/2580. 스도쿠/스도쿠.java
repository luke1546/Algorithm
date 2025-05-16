import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N = 9, map[][];
	static ArrayList<int[]> list = new ArrayList<>();
	static boolean end = false;
	public static void main(String[] args) throws IOException {
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j] = x;
				if(x == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		dfs(0);
	}
	private static boolean check(int[] cur, int x) {
		for(int i=0; i<9; i++) {
			if(map[cur[0]][i] == x) return false;
			if(map[i][cur[1]] == x) return false;
		}
		int nr = cur[0] - (cur[0]%3);
		int nc = cur[1] - (cur[1]%3);
		for(int i=nr; i<nr+3; i++) {
			for(int j=nc; j<nc+3; j++) {
				if(map[i][j] == x) return false;
			}
		}
		return true;
	}
	private static void dfs(int cnt) {
		if(end) return;
		if(cnt == list.size()) {
			print();
			end = true;
			return;
		}
		for(int i=1; i<=9; i++) {
			if(!check(list.get(cnt), i)) continue;
			int[] cur = list.get(cnt);
			map[cur[0]][cur[1]] = i;
			dfs(cnt+1);
			map[cur[0]][cur[1]] = 0;
		}
	}
	private static void print() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}

/*
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0

1 3 5 4 6 9 2 7 8
7 8 2 1 3 5 6 4 9
4 6 9 2 7 8 1 3 5
3 2 1 5 4 6 8 9 7
8 7 4 9 1 3 5 2 6
5 9 6 8 2 7 4 1 3
9 1 7 6 5 2 3 8 4
6 4 3 7 8 1 9 5 2
2 5 8 3 9 4 7 6 1
*/
