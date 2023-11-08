import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K, parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, int[]> object = new HashMap<>();
		ArrayList<int[]> obj = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		make();
		st = new StringTokenizer(br.readLine()," ");
		int[] candy = new int[N];
		for(int i=0; i<N; i++)	candy[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			union(a,b);
		}
		
//		for(int i=0; i<N; i++) 
//			System.out.println(find(i));
		
		for(int i=0; i<N; i++) {
			if(!object.containsKey(find(i)))
				object.put(find(i), new int[] {1,candy[i]});
			else
				object.put(find(i), new int[] 
						{object.get(find(i))[0]+1, object.get(find(i))[1]+candy[i]});
				
		}
		int dp[] = new int[K];
		
		for(int i : object.keySet())	obj.add(object.get(i));
		for(int i[] : obj) {
			for(int j=K-1; j-i[0]>=0; j--) {
				dp[j] = Math.max(dp[j], i[1]+dp[j-i[0]]);
			}
		}
		System.out.println(dp[K-1]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)	return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++)	parents[i] = i;
	}
}
