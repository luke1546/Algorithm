import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int V,E, distance[];
	static boolean visit[];
	static ArrayList<ArrayList<int[]>> graph;
	static PriorityQueue<int[]> pq;
	public static void main(String[] args) throws IOException {
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		distance = new int[V];
		visit = new boolean[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		graph = new ArrayList<>();
		pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
		for(int i=0; i<V; i++) graph.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new int[] {to, weight});
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		distance[start] = 0;
		pq.add(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
            if(visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for(int[] v : graph.get(cur[0])) {
				if(!visit[v[0]] && distance[v[0]] > v[1] + cur[1]) {
					distance[v[0]] = v[1] + cur[1];
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