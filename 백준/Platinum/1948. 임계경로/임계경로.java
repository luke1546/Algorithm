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
	public static void main(String[] args) throws IOException {
		 ArrayList<ArrayList<int[]>> graph1 = new ArrayList<>();
		 ArrayList<ArrayList<int[]>> graph2 = new ArrayList<>();
		 PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o2[1] - o1[1]);
		 int n = Integer.parseInt(br.readLine());
		 int m = Integer.parseInt(br.readLine());
		 int ans = 0;
		 int distance[] = new int[n];
		 boolean[] visit = new boolean[n];
		 for(int i=0; i<n; i++) graph1.add(new ArrayList<>());
		 for(int i=0; i<n; i++) graph2.add(new ArrayList<>());
		 for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int from = Integer.parseInt(st.nextToken())-1;
			 int to = Integer.parseInt(st.nextToken())-1;
			 int weight = Integer.parseInt(st.nextToken());
			 graph1.get(from).add(new int[] {to, weight});
			 graph2.get(to).add(new int[] {from, weight});
		 }
		 st = new StringTokenizer(br.readLine(), " ");
		 int start = Integer.parseInt(st.nextToken())-1;
		 int end = Integer.parseInt(st.nextToken())-1;
		 Arrays.fill(distance, Integer.MIN_VALUE);
		 distance[start] = 0;
		 pq.add(new int[] {start, 0});
		 while(!pq.isEmpty()) {
			 int cur[] = pq.poll();
			 for(int[] v : graph1.get(cur[0])) {
				 if(distance[v[0]] < v[1] + cur[1]) {
					 distance[v[0]] = v[1] + cur[1];
					 pq.add(new int[] {v[0], v[1] + cur[1]});
				 }
			 }
		 }
		 Deque<Integer> dq = new ArrayDeque<>();
		 dq.offer(end);
		 visit = new boolean[n];
		 while(!dq.isEmpty()) {
			 int cur = dq.poll();
			 if(visit[cur]) continue;
			 visit[cur] = true;
			 for(int v[] : graph2.get(cur)) {
				 if(distance[cur] - distance[v[0]] - v[1] == 0) {
					 dq.add(v[0]);
					 ans++;
				 }
			 }
		 }
		 System.out.println(distance[end]);
		 System.out.println(ans);
	}
}

/*
7
9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5
1 7

12
5
*/