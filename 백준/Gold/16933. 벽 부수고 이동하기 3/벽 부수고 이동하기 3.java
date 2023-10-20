import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K, map[][], min=Integer.MAX_VALUE;
	static int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int ans = 1;
	static ArrayDeque<int[]> dq= new ArrayDeque<>();
	static int visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(),"");
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		visit = new int[R][C];
		for(int i=0; i<R; i++)	Arrays.fill(visit[i], Integer.MAX_VALUE);
		dq.offer(new int [] {0,0,K,1,1});
		visit[0][0] = 0;
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
			if(nr >= 0 && nr<R && nc>=0 && nc<C && visit[nr][nc] > K-cur[2]) {
				if(map[nr][nc] != 1) {
					visit[nr][nc] = K-cur[2];
					dq.offer(new int[] {nr,nc,cur[2],cur[3]+1,-cur[4]});
				}else if(map[nr][nc] == 1 && cur[2] > 0 && visit[nr][nc] > K-cur[2]+1 && cur[4]==1) {
					visit[nr][nc] = K-cur[2]+1;
					dq.offer(new int[] {nr,nc,cur[2]-1,cur[3]+1,-cur[4]});
				}else if(map[nr][nc] == 1 && cur[2] > 0 && visit[nr][nc] > K-cur[2]+1 && cur[4]==-1) {
					dq.offer(new int[] {nr-dir[0],nc-dir[1],cur[2],cur[3]+1,-cur[4]});
				}
			}
		}
	}
}
