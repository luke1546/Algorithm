import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, map[][], dirs[][] = {{0,-1},{1,0},{0,1},{-1,0}}, ans = 0;
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
	static int dustDirs[][][] = {
			{{0,-2},{2,0},{0,2},{-2,0}},
			{{-1,-1},{1,-1},{1,1},{-1,1}},
			{{1,-1},{1,1},{-1,1},{-1,-1}},
			{{-1,0},{0,-1},{1,0},{0,1}},
			{{1,0},{0,1},{-1,0},{0,-1}},
			{{-2,0},{0,-2},{2,0},{0,2}},
			{{2,0},{0,2},{-2,0},{0,-2}},
			{{1,1},{-1,1},{-1,-1},{1,-1}},
			{{-1,1},{-1,-1},{1,-1},{1,1}}
			};
	static int rate[] = {5, 10, 10, 7, 7, 2, 2, 1, 1};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tonadolist();
		tonado();
		System.out.println(ans);
	}
	private static void tonado() {
		while(!dq.isEmpty()){
			int sum = 0;
			int cur[] = dq.poll();
			int target = map[cur[0]][cur[1]];
			if(target==0) continue;
			for(int i=0; i<9; i++) {
				int sand = target * rate[i] / 100;
				if(sand == 0) continue;
				int nr = cur[0] + dustDirs[i][cur[2]][0];
				int nc = cur[1] + dustDirs[i][cur[2]][1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					map[nr][nc]+=sand;
				}else {
					ans+=sand;
				}
				sum += sand;
			}
			int r = cur[0] + dirs[cur[2]][0];
			int c = cur[1] + dirs[cur[2]][1];
			if(r >= 0 && r < N && c >= 0 && c < N) {
				map[r][c]+=(target-sum);
			}else ans += (target-sum);
		}
	}
	private static void tonadolist() {
		int cur[] = new int[] {N/2,N/2};
		int d = 0;
		int cnt = 0;
		int dis = 1;
		int curDis = 0;
		for(int i=0; i<(N*N)-1; i++) {
			int nr = cur[0] + dirs[d][0];
			int nc = cur[1] + dirs[d][1];
			dq.offer(new int[] {nr,nc,d});
			cur[0] = nr;
			cur[1] = nc;
			if(++curDis == dis) {
				curDis=0;
				cnt++;
				d++;
				d%=4;
			}
			if(cnt == 2) {
				cnt = 0;
				dis++;
			}
		}
	}
}
