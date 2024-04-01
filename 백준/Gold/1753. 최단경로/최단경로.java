import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<int[]>> 인접리스트 = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0])-1;
		int[] distance = new int[V];
		boolean[] visit = new boolean[V];
		for(int i=0; i<V; i++)
			인접리스트.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0])-1;
			int to = Integer.parseInt(str[1])-1;
			int weight = Integer.parseInt(str[2]);
			인접리스트.get(from).add(new int[] {to,weight});
		}
		int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		pq.offer(new int[] {start,0});
		distance[start] = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(visit[cur[0]])	continue;
			visit[cur[0]]=true;
			for(int v[] : 인접리스트.get(cur[0])) {
				if(!visit[v[0]] && distance[v[0]] > cur[1] + v[1]) {
					distance[v[0]] = cur[1]+v[1];
					pq.offer(new int[] {v[0],distance[v[0]]});
				}
			}
		}
		for(int i : distance)
			sb.append(i != INF ? i+"\n" : "INF\n");
		System.out.println(sb.toString());
	}
}