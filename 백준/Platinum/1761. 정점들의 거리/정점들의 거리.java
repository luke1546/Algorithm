import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int v,w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public String toString() {
			return v+" "+w;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
	static int V, E, logN, depth[];
	static Node table[][];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		V = Integer.parseInt(br.readLine());
		logN = (int)(Math.log(V) / Math.log(2)) + 1;
		visit = new boolean[V];
		table = new Node[logN][V];
		depth = new int[V];
		for(int i=0; i<V; i++) list.add(new ArrayList<>());
		for(int i=0; i<V-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new int[] {to, weight});
			list.get(to).add(new int[] {from, weight});
		}
		bfs(0);
		
		
		
		for(int i=0; i<logN; i++) {
			for(int j=1; j<V; j++) {
				int v = j;
				int w = 0;
				for(int k=0; k<i; k++) {
					if(table[k][v] != null) {
						w += table[k][v].w;
						v = table[k][v].v;
					}
				}
				if(v == 0) continue;
				w += list.get(v).get(0)[1];
				v = list.get(v).get(0)[0];
				table[i][j] = new Node(v, w);
			}
		}
		
		
		E = Integer.parseInt(br.readLine());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			sb.append(findLCA(a,b)).append("\n");
		}
		System.out.print(sb);
	}
	private static int findLCA(int a, int b) {
		if(depth[a] < depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int diff = depth[a] - depth[b];
		int index = 0;
		int w = 0;
		while(diff > 0) {
			if((diff & 1) == 1) {
				w += table[index][a].w;
				a = table[index][a].v;
			}
			index++;
			diff>>=1;
		}
		if(a != b) {
			for(int i=logN-1; i>=0; i--) {
				if(table[i][a] != null && table[i][b] != null && table[i][a].v != table[i][b].v) {
					w += table[i][a].w;
					w += table[i][b].w;
					a = table[i][a].v;
					b = table[i][b].v;
				}
			}
			w += table[0][a].w;
			w += table[0][b].w;
			return w;
		}
		return w;
	}
	private static void bfs(int x) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {x,0});
		visit[x] = true;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			depth[cur[0]] = cur[1];
			for(int i=0; i<list.get(cur[0]).size(); i++) {
				int v = list.get(cur[0]).get(i)[0];
				if(!visit[v]) {
					visit[v] = true;
					dq.offer(new int[] {v,cur[1]+1});
					list.get(cur[0]).remove(i);
					i = i-1;
				}
			}
		}
	}
}


/*
7
1 6 13
6 3 9
3 5 7
4 1 3
2 4 20
4 7 2
3
1 6
1 4
2 6

13
3
36
*/