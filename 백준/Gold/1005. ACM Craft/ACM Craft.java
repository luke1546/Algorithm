import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[];
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
			for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] cost = new int[V];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<V; i++)	cost[i] = Integer.parseInt(st.nextToken());
			boolean visit[] = new boolean[V];
			int degrees[] = new int[V];
			ArrayList<ArrayList<Integer>> 그래프 = new ArrayList<>();
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
			for(int i=0; i<V; i++)	그래프.add(new ArrayList<>());
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				그래프.get(from).add(to);
				degrees[to]++;
			}
			int target = Integer.parseInt(br.readLine())-1;
			for(int i=0; i<V; i++) {	
				if(degrees[i] == 0) {	
					visit[i] = true;
					if(visit[target]) {
						sb.append(cost[i] + "\n");
						break;
					}
					pq.offer(new int[] {i,cost[i]});
				}
			}
			while(!pq.isEmpty()) {
				int cur[] = pq.poll();
				if(cur[0] == target) {
					sb.append(cur[1] + "\n");
					break;
				}
				for(int i : 그래프.get(cur[0])) {
					degrees[i]--;
					if(degrees[i] == 0 && !visit[i]) {
						visit[i] = true;
						pq.offer(new int[] {i,cost[i] + cur[1]});
					}
				}
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
