import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
	static int R, C, map[][], min=Integer.MAX_VALUE;
	static int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int ans = 1;
	static ArrayDeque<int[]> dq= new ArrayDeque<>();
	static boolean visit[][];
	static boolean visit2[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		visit = new boolean[R][C];
		visit2 = new boolean[R][C];
		dq.offer(new int [] {0,0,1,1});
		visit[0][0] = true;
		while(!dq.isEmpty())	BFS();
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}
	private static void BFS() {
		int cur[] = dq.poll();
		if(cur[0] == R-1 && cur[1] == C-1) { 
			min = Math.min(min, cur[3]);
		}
		for(int dir[] : dirs) {
			int nr = cur[0]+dir[0];
			int nc = cur[1]+dir[1];
			if(nr >= 0 && nr<R && nc>=0 && nc<C && !visit[nr][nc]) {
				if(cur[2] == 0 && visit2[nr][nc])	continue;
				if(map[nr][nc] == 1) {
					if(cur[2] == 0)	continue;
					visit2[nr][nc] = true;
					dq.offer(new int[] {nr,nc,cur[2]-1,cur[3]+1});
				}else {
					if(cur[2] == 0) visit2[nr][nc] = true;
					else	visit[nr][nc] = true;
					dq.offer(new int[] {nr,nc,cur[2],cur[3]+1});
				}
			}
		}
	}
}
