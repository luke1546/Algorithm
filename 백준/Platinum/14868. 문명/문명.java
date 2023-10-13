import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static int[][] map, dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[] parents;
	static int N, K, cnt=1, ans=0;
	static ArrayDeque<int[]> dq1 = new ArrayDeque<>();
	static ArrayDeque<int[]> dq2 = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);		//map 크기
		K = Integer.parseInt(str[1]);		//부족 수
		map = new int[N][N];
		for(int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			int r = Integer.parseInt(str[1])-1;
			int c = Integer.parseInt(str[0])-1;
			map[r][c] = i+1;
			dq1.offer(new int[] {r,c});
			dq2.offer(new int[] {r,c});
		}
		make();
		인접검사();
		if(cnt == K) {
			System.out.println(ans);
			return;
		}
		while(true) {
			ans++;
			문명증식();
			인접검사();
			if(cnt == K) break;
		}
		System.out.println(ans);
//		for(int i[] : map)	System.out.println(Arrays.toString(i));
	}
	private static void 문명증식() {
		int size = dq2.size();
		for(int i=0; i<size; i++) {
			int cur[] = dq2.poll();
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] == 0) {
						map[nr][nc] = map[cur[0]][cur[1]];
						dq1.offer(new int[] {nr,nc});
						dq2.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}
	private static void 인접검사() {
		while(!dq1.isEmpty()) {
			int cur[] = dq1.poll();
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] != 0 && map[nr][nc] != map[cur[0]][cur[1]])	
						if(union(map[nr][nc], map[cur[0]][cur[1]])) cnt++;
				}
			}
		}
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)	return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int i) {
		if(parents[i] == i)	return i;
		return parents[i] = find(parents[i]);
	}
	private static void make() {
		parents = new int[K+1];
		for(int i=0; i<K+1; i++) parents[i] = i;
	}
}
