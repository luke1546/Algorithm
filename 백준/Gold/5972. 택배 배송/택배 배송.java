import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<int[]>> al = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[N];
		int distance[] = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<N; i++) al.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			al.get(from).add(new int[] {to, w});
			al.get(to).add(new int[] {from, w});
		}
		int start = 0;
		int end = N-1;
		distance[start] = 0;
		pq.offer(new int[] {start,0});
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for(int[] v : al.get(cur[0])) {
				if(distance[v[0]] > cur[1] + v[1]) {
					distance[v[0]] = cur[1] + v[1];
					pq.offer(new int[] {v[0], v[1] + cur[1]});
				}
			}
		}
		System.out.println(distance[end]);
	}
}
