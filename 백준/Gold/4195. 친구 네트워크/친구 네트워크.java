import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int parents[], group[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 0; tc < T; tc++) {
			HashMap<String, Integer> hm = new HashMap<>();
			group = new int[200000];
			Arrays.fill(group, 1);
			make();
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(!hm.containsKey(str1))	hm.put(str1, cnt++);
				if(!hm.containsKey(str2))	hm.put(str2, cnt++);
				int size = group[find(hm.get(str2))];
				if(union(hm.get(str1), hm.get(str2))) {
					group[find(hm.get(str1))]+=size;
				}
				sb.append(group[find(hm.get(str1))] + "\n");
			}
		}
		System.out.println(sb.toString());
	}
	private static void make() {
		parents = new int[200000];
		for(int i=0; i<parents.length; i++)	parents[i] = i;
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
}
