import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, distance[];
	static boolean visit[];
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<ArrayList<int[]>> 그래프 = new ArrayList<>();
		V = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		E = Integer.parseInt(st.nextToken());
		distance = new int[V];
		visit = new boolean[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<V; i++)	그래프.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			그래프.get(from).add(new int[] {to,weight});
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		pq.offer(new int[] {start, 0});
		distance[start] = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for(int v[] : 그래프.get(cur[0])) {
				if(!visit[v[0]] && distance[v[0]] > cur[1] + v[1]) {
					distance[v[0]] = cur[1] + v[1];
					pq.offer(new int[] {v[0], distance[v[0]]});
				}
			}
		}
		System.out.println(distance[end]);
	}
}

/*
bj_1916
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
answer : 
4
 */
