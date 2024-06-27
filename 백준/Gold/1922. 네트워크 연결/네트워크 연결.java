import java.util.*;
import java.io.*;

public class Main{
	static int V, E, parents[];
	public static void main(String[] args)throws Exception {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		for(int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a,b,w});
		}
		int cnt = 0;
		int ans = 0;
		make();
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(union(cur[0],cur[1])) {
				cnt++;
				ans+=cur[2];
			}
		}
		System.out.println(ans);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static void make() {
		parents = new int[V+1];
		for(int i=0; i<V+1; i++) parents[i] = i;
	}
}

/*

6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

23
*/