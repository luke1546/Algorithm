import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
	public static class Cave{
		int hole;
		int weight;
		public Cave(int hole, int weight) {
			this.hole = hole;
			this.weight = weight;
		}
		public String toString() {
			return hole + " " + weight;
		}
	}
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		int logn = (int)(Math.log(N) / Math.log(2));
		Cave[][] sparseTable = new Cave[logn+1][N];
		int energy[] = new int[N];
		for(int i=0; i<N; i++) {
			energy[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<N; i++) graph.add(new ArrayList<>());
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new int[] {to, weight});
			graph.get(to).add(new int[] {from, weight});
		}
		bfs();
		for(int i=0; i<logn+1; i++) {
			for(int j=1; j<N; j++) {
				int hole = j;
				int weight = 0;
				int k = 1;
				while(i-k >= 0 && sparseTable[i-k][hole] != null) {
					weight += sparseTable[i-k][hole].weight;
					hole = sparseTable[i-k][hole].hole;
					k++;
				}
				if(hole == 0) continue;
				weight += graph.get(hole).get(0)[1];
				hole = graph.get(hole).get(0)[0];
				sparseTable[i][j] = new Cave(hole, weight);
			}
		}
		for(int i=0; i<N; i++) {
			int floor = i;
			int k = logn;
			while(floor != 0 && k >= 0){
				if(sparseTable[k][floor] != null && energy[i] - sparseTable[k][floor].weight >= 0) {
					energy[i] -= sparseTable[k][floor].weight;
					floor = sparseTable[k][floor].hole;
				}
				k--;
			}
			sb.append(floor+1+"\n");
		}
		System.out.print(sb);
	}
	private static void bfs() {
		boolean visit[] = new boolean[N];
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(0);
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			visit[cur] = true;
			for(int i = 0; i<graph.get(cur).size(); i++) {
				int v[] = graph.get(cur).get(i);
				if(!visit[v[0]]) {
					dq.add(v[0]);
					graph.get(cur).remove(i);
					i = i-1;
				}
			}
		}
	}
}


/*
9
49
17
45
27
49
33
34
14
28
2 3 6
5 9 10
4 1 8
5 1 6
9 8 3
8 3 1
2 6 10
4 7 10


1
9
1
1
1
5
1
5
1
*/