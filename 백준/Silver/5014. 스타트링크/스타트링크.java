import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int F,S,G,U,D,ans = Integer.MAX_VALUE;
	static int dir[] = new int[2];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		dir[0] = Integer.parseInt(st.nextToken());
		dir[1] = -1 * Integer.parseInt(st.nextToken());
		visit = new boolean[F+1];
		bfs();
		System.out.println(ans==Integer.MAX_VALUE ? "use the stairs" : ans);
	}
	private static void bfs() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {S,0});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			if(cur[0] == G) {
				ans = cur[1];
				return;
			}
			for(int d : dir) {
				int floor = cur[0] + d;
				if(floor >= 1 && floor <= F && !visit[floor]) {
					visit[floor] = true;
					dq.add(new int[] {floor, cur[1]+1});
				}
			}
		}
	}
}




/*
10 1 10 2 1
6


100 2 1 1 0
use the stairs
*/