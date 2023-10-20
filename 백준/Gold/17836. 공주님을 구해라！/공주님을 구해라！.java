import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T, sword[], map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		sword = new int[2];
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) { 
					sword[0] = i+1;
					sword[1] = j+1; 
				}
			}
		}
		int ans = 0;
		if(BFS(0,0,sword[0],sword[1]) == Integer.MAX_VALUE) {
			System.out.println("Fail");
			return;
		}
		ans = Math.min(BFS(0,0,R,C), BFS(0,0,sword[0],sword[1]) + swordToPrincess());
		System.out.println(ans > T ? "Fail" : ans);
	}
	private static int BFS(int i, int j, int tr, int tc) {
		int ans=0;
		boolean[][] visit = new boolean[R][C];
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0,0,0});
		visit[0][0] = true;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
//			System.out.println(Arrays.toString(cur));
			if(cur[0] == tr-1 && cur[1] == tc-1) {
				ans=cur[2];
				break;
			}
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == 0 || map[nr][nc] == 2) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					dq.offer(new int[] {nr,nc,cur[2]+1});
				}
			}
		}
		if(ans==0) ans = Integer.MAX_VALUE;
		return ans;
	}
	private static int swordToPrincess() {
		return Math.abs(R-sword[0]) + Math.abs(C-sword[1]);
	}
}
