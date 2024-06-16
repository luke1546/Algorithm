import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<int[]> graph = new ArrayList<>();
	static int N, D, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			graph.add(new int[] {start, end, distance});
		}
		bfs();
		System.out.println(min);
	}
	private static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0,0});
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			if(cur[0] > D) continue; 
			min = Math.min(min, D-cur[0] + cur[1]);
			for(int[] v : graph) {
				if(v[2] < v[1] - v[0] && v[0] >= cur[0]) {
					dq.offer(new int[] {v[1], cur[1] + v[0]-cur[0] + v[2]});
				}
			}
		}
	}
}
