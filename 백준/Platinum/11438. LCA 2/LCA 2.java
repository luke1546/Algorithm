import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int N, logN;
	static int depth[];
	static int sparseTable[][];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		depth = new int[N];
		for(int i=0; i<N; i++) graph.add(new ArrayList<>());
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		bfs();
		logN = (int)(Math.log(N) / Math.log(2)) + 1;
		
		sparseTable = new int[logN][N];
//		for(int i=0; i<N; i++) {
//			if(!graph.get(i).isEmpty()) sparseTable[0][i] = graph.get(i).get(0);
//		}
		for(int i=0; i<logN; i++) {
			for(int j=0; j<N; j++) {
				if(graph.get(j).isEmpty()) {
					continue;
				}
				int v = graph.get(j).get(0);
				for(int k=0; k<i; k++) {
					v = sparseTable[k][v];
				}
				sparseTable[i][j] = v;
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			sb.append(findLCA(a,b)).append("\n");
		}
		System.out.print(sb);
	}
	private static int findLCA(int a, int b) {
		if(depth[a] < depth[b]) {
			int temp = b;
			b = a;
			a = temp;
		}
		int dif = depth[a] - depth[b];
		int x = 0;
		while(dif != 0) {
			if((dif & 1) == 1) a = sparseTable[x][a];
			x++;
			dif>>=1;
		}
		
		if(a != b) {
			for(int i = logN-1; i>=0; i--) {
				if(sparseTable[i][a] != sparseTable[i][b]) {
					a = sparseTable[i][a];
					b = sparseTable[i][b];
				}
			}
		return sparseTable[0][a]+1;
		}else return a+1;
		
	}
	private static void bfs() {
		boolean[] visit = new boolean[N];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0,0});
		visit[0] = true;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			depth[cur[0]] = cur[1];
			for(int i=0; i<graph.get(cur[0]).size(); i++) {
				int v = graph.get(cur[0]).get(i);
				if(!visit[v]) {
					dq.add(new int[] {v,cur[1]+1});
					visit[v] = true;
					graph.get(cur[0]).remove(i);
					i = i-1;
				}
			}
		}
	}
}

/*
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15

2
4
2
1
3
1
*/