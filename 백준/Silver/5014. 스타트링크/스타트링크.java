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
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visit = new boolean[F+1];
		bfs();
		System.out.println(ans==Integer.MAX_VALUE ? "use the stairs" : ans);
	}
	private static void bfs() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {S,0});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			if(cur[0] == G) ans = Math.min(ans, cur[1]);
			int up = cur[0] + U;
			int down = cur[0] - D;
			if(up <= F && !visit[up]) {
				visit[up] = true;
				dq.add(new int[] {up, cur[1]+1});
			}
			if(down >= 1 && !visit[down]) {
				visit[down] = true;
				dq.add(new int[] {down, cur[1]+1});
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