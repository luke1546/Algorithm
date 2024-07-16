import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, dp[][];
	static boolean visit[];
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N][2];
		visit = new boolean[N];
		for(int i=0; i<N; i++) tree.add(new ArrayList<>());
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			tree.get(from).add(to);
			tree.get(to).add(from);
		}
		dfs(0);
		System.out.println(Math.min(dp[0][0], dp[0][1]));
	}
	private static void dfs(int parent) {
		dp[parent][0] = 0;
		dp[parent][1] = 1;
		visit[parent] = true;
		for(int child : tree.get(parent)) {
			if(visit[child]) continue;
			dfs(child);
			dp[parent][0] += dp[child][1];
			dp[parent][1] += Math.min(dp[child][0], dp[child][1]);
		}
	}
}

/*
0 : 일반인 -> 자식은 모두 얼리어답터
1 : 얼리어답터 -> 자식은 얼리 or 일반인

8
1 2
1 3
1 4
2 5
2 6
4 7
4 8

3
*/