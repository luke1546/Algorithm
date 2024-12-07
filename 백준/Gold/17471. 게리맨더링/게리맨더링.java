import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	static int N, arr[], min = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<Integer> comb1;
	static ArrayList<Integer> comb2;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list.add(new ArrayList<>());
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for(int j=0; j<n; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		}
		부분조합();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	private static void 부분조합() {
		for(int i=0; i<1<<N; i++) {
			HashSet<Integer> set = new HashSet<>();
			comb1 = new ArrayList<>();
			comb2 = new ArrayList<>();
			for(int j=0; j<N; j++) {
				if((i & 1<<j) > 0) {
					comb1.add(j);
				}
				comb2.add(j);
			}
			for(int j=0; j<comb1.size(); j++) comb2.remove(comb1.get(j));
			if(comb1.size() == 0 || comb2.size() == 0) continue;
			if(bfs(comb1) && bfs(comb2)) {
				int diff = 0;
				for(int j=0; j<comb1.size(); j++) {
					diff += arr[comb1.get(j)];
				}
				for(int j=0; j<comb2.size(); j++) {
					diff -= arr[comb2.get(j)];
				}
				min = Math.min(min, Math.abs(diff));
			}
			
		}
	}
	private static boolean bfs(ArrayList<Integer> comb) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int cnt = 1;
		dq.add(comb.get(0));
		boolean visit[] = new boolean[N];
		visit[comb.get(0)] = true;
		while(!dq.isEmpty()) {
			int c = dq.poll();
			for(int v : list.get(c)) {
				if(!visit[v] && comb.contains(v)) {
					dq.offer(v);
					visit[v] = true;
					cnt++;
				}
			}
		}
		if(cnt == comb.size()) return true;
		return false;
	}
}

/*
6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2

1
*/