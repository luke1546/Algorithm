import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean visit[];
	static int V, E, distance[];
	public static void main(String[] args) throws IOException {
		while(true) {
			ArrayList<ArrayList<int[]>> graph1 = new ArrayList<>();
			ArrayList<ArrayList<int[]>> graph2 = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V == 0) break;
			visit = new boolean[V];
			distance = new int[V];
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for(int i=0; i<V; i++) {
				graph1.add(new ArrayList<>());
				graph2.add(new ArrayList<>());
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph1.get(from).add(new int[] {to, weight});
				graph2.get(to).add(new int[] {from, weight});
			}
			다익스트라(graph1, start);
			그래프지우기(graph2, end);
			distance = new int[V];
			visit = new boolean[V];
			다익스트라(graph2, end);
			if(distance[start] == Integer.MAX_VALUE) sb.append(-1).append("\n");
			else sb.append(distance[start]).append("\n");
		}
		System.out.print(sb);
	}
	private static void 그래프지우기(ArrayList<ArrayList<int[]>> graph, int end) {
		boolean[] flag = new boolean[V];
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(end);
		flag[end] = true;
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			for(int i=0; i<graph.get(cur).size(); i++) {
				int v[] = graph.get(cur).get(i);
				if(distance[cur] - distance[v[0]] == v[1]) {
					graph.get(cur).remove(i);
					i-=1;
					if(!flag[v[0]]) {
						flag[v[0]] = true;
						dq.offer(v[0]);
					}
				}
			}
		}
	}
	private static void 다익스트라(ArrayList<ArrayList<int[]>> graph, int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start,0});
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for(int v[] : graph.get(cur[0])) {
				if(!visit[v[0]] && distance[v[0]] > v[1] + cur[1]) {
					distance[v[0]] = v[1] + cur[1];
					pq.offer(new int[] {v[0], v[1] + cur[1]});
				}
			}
		}
	}
}


/*
7 9
0 6
0 1 1
0 2 1
0 3 2
0 4 3
1 5 2
2 6 4
3 6 2
4 6 4
5 6 1
4 6
0 2
0 1 1
1 2 1
1 3 1
3 2 1
2 0 3
3 0 2
6 8
0 1
0 1 1
0 2 2
0 3 3
2 5 3
3 4 2
4 1 1
5 1 1
3 0 1
0 0

5
-1
6
*/