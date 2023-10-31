import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, parents[];
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {from, to, weight});
		}
		make();
		int ans=0;
		int cnt=0;
		int max=0;
		while(!pq.isEmpty()) {
			if(cnt==V-1) break;
			int cur[] = pq.poll();
			if(union(cur[0],cur[1])) {
				cnt++;
				ans+=cur[2];
				max = Math.max(max, cur[2]);
			}
		}
		System.out.println(ans-max);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int a) {
		if(parents[a] == a)	return a;
		return parents[a] = find(parents[a]);
	}
	private static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++)	parents[i] = i;
	}
}
