import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		for(int i=0; i<N; i++) list.add(new ArrayList<>());
		boolean visit[] = new boolean[N];
		int[] distance = new int[N];
		Arrays.fill(distance, 1000000000);
		distance[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new int[] {to, weight});
			list.get(to).add(new int[] {from, weight});
		}
		pq.offer(new int[] {start,0});
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(visit[cur[0]]) continue;
			visit[cur[0]] = true;
			for(int v[] : list.get(cur[0])) {
				if(distance[v[0]] > v[1] + cur[1]  && !visit[v[0]]) {
					distance[v[0]] = v[1] + cur[1];
					pq.offer(new int[] {v[0], v[1] + cur[1]});
				}
			}
		}
		Arrays.sort(distance);
		boolean flag = true;
		int ans = 1;
		int hp = X;
		for(int i=0; i<N; i++) {
			if(distance[i] * 2 > X) {
				flag = false;
				break;
			}
			if(hp - distance[i]*2 >= 0) {
				hp -= distance[i]*2;
			}else {
				hp = X;
				ans++;
				hp -= distance[i]*2;
			}
		}
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}
}

/*
5 6 21 0
0 1 6
0 2 3
0 3 10
1 2 2
2 4 7
3 4 8

3
*/