import java.util.*;
import java.io.*;

public class Main {
	static char map[][];
	static int selected[], ans = 0, dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int visit[][], hash = 0;
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		selected = new int[7];
		visit = new int[5][5];
		for(int i=0; i<5; i++) {
			String line = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		comb(0,0);
		System.out.println(ans);
	}
	public static void comb(int start, int cnt) {
		if(cnt == 7) {
			hash++;
			if(isLinked(selected, hash)) {
				int count = countS(selected);
				if(count >= 4) ans++;
			}
			return;
		}
		for(int i=start; i<25; i++) {
			selected[cnt] = i;
			comb(i+1, cnt+1);
		}
	}
	private static int countS(int[] selected) {
		int cnt = 0;
		for(int i=0; i<selected.length; i++) {
			int r = selected[i]/5;
			int c = selected[i]%5;
			if(map[r][c] == 'S') cnt++;
		}
		return cnt;
	}
	private static boolean isLinked(int[] selected, int hash) {
		int cnt = 1;
		for(int i=0; i<selected.length; i++) {
			int r = selected[i]/5;
			int c = selected[i]%5;
			visit[r][c] = hash;
		}
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		int r = selected[0]/5;
		int c = selected[0]%5;
		dq.offer(new int[] {r, c});
		visit[r][c] = 0;
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && visit[nr][nc] == hash) {
					dq.offer(new int[] {nr,nc});
					cnt++;
					visit[nr][nc] = 0;
				}
			}
		}
		return cnt==7;
	}
}

/*
YYYYY
SYSYS
YYYYY
YSYYS
YYYYY

2
*/