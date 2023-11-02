import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, Q, map[][], magic[], dirs[][] = {{-1, 0}, {0,1},{1,0},{0,-1}}, max = 0;
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		map = new int[N][N];
		visit = new boolean[N][N];
		magic = new int[Q];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<Q; i++)	magic[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<Q; i++) {
			tornado(magic[i]);
			fire();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && map[i][j]!=0)	max = Math.max(max, bfs(i, j));
			}
		}
		
		System.out.println(count());
		System.out.println(max);
		
//		for(int i[] : map)
//		System.out.println(Arrays.toString(i));
	}
	private static int bfs(int i, int j) {
		int ans = 1;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {i,j});
		visit[i][j] = true;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && map[nr][nc] > 0) {
					dq.offer(new int[] {nr,nc});
					visit[nr][nc] = true;
					ans++;
				}
			}
		}
		return ans;
	}
	private static int count() {
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				ans += map[i][j];
			}
		}
		return ans;
	}
	private static void fire() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 0;
				if(map[i][j] != 0) {
					for(int dir[] : dirs) {
						int nr = i+dir[0];
						int nc = j+dir[1];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > 0)	cnt++;
					}
					if (cnt < 3)	dq.offer(new int [] {i,j});
				}
			}
		}
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			map[cur[0]][cur[1]]--;
		}
	}
	private static void tornado(int L) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int n = (int) Math.pow(2, L);
		for(int i=0; i<N; i+=n) {
			for(int j=0; j<N; j+=n) {
				for(int k=i+n-1; k>=i; k--) {
					for(int l=j; l<j+n; l++) {
						dq.offer(map[k][l]);
					}
				}
				for(int k=j; k<j+n; k++) {
					for(int l=i; l<i+n; l++) {
						map[l][k] = dq.poll();
					}
				}
			}
		}
	}
}
