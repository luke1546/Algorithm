import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[] visit;
	static int[] parents;
	static int V, E, id=0;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> SCCS = new ArrayList<>();
	static Stack<Integer> s = new Stack<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visit = new boolean[V];
		parents = new int[V];
		for(int i=0; i<V; i++) list.add(new ArrayList<Integer>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			list.get(from).add(to);
		}
		for(int i=0; i<V; i++) {
			if(!visit[i]) dfs(i);
		}
		sb.append(SCCS.size()).append("\n");
		for(int i=0; i<SCCS.size(); i++) Collections.sort(SCCS.get(i));
		Collections.sort(SCCS, (o1,o2) -> o1.get(0) - o2.get(0));
		for(int i=0; i<SCCS.size(); i++) {
			for(int j=0; j<SCCS.get(i).size(); j++) {
				sb.append(SCCS.get(i).get(j)+1).append(" ");
			}
			sb.append("-1\n");
		}
		System.out.println(sb);
	}
	
	private static int dfs(int x) {
		parents[x] = ++id;
		s.push(x);
		int parent = parents[x];
		
		for(int v : list.get(x)) {
			if(parents[v] == 0) {
				parent = Math.min(parent, dfs(v));
			}
			else if(!visit[v]) parent = Math.min(parent, parents[v]);
		}
		
		if(parent == parents[x]) {
			ArrayList<Integer> scc = new ArrayList<>();
			while(true) {
				int t = s.pop();
				scc.add(t);
				visit[t] = true;
				if(t == x) break;
			}
			SCCS.add(new ArrayList<>(scc));
		}
		return parent;
	}
	
}

/*
7 9
1 4
4 5
5 1
1 6
6 7
2 7
7 3
3 7
7 2

3
1 4 5 -1
2 3 7 -1
6 -1
*/