import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, map[][], max=0;
	static int visit[][];
	static int dirs[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new int[R][C];
		for(int v[] : visit)	Arrays.fill(v, 51);
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 1) {
					dq.offer(new int[] {i,j,0});
					아기상어찾기();
				}
			}
		}
		for(int a[] : visit)
			for(int i : a)
				if(i != 51)
					max = Math.max(max, i);
		System.out.println(max);
	}
	private static void 아기상어찾기() {
		int dt = 0;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && visit[nr][nc] > cur[2] + 1) {
					if(map[nr][nc] == 0)	{
						visit[nr][nc] = cur[2] + 1;
						dq.offer(new int[] {nr,nc,cur[2]+1});
					}
				}
			}
		}
	}
}
