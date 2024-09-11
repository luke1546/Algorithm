import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int ans = 0;
		HashMap<String, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		Integer arr[][] = new Integer[N][M];
		for(int tc=0; tc<N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<M; i++) {
//				int x = Integer.parseInt(st.nextToken());
				list.add(Integer.parseInt(st.nextToken()));
//				arr[tc][i] = x;
			}
//			Collections.sort(list);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) sb.append(Collections.binarySearch(list, list.get(i))).append(" ");
			if(map.containsKey(sb.toString())) map.put(sb.toString(), map.get(sb.toString())+1);
			else map.put(sb.toString(), 1);
//			map.merge(sb.toString(), 1, Integer::sum);
		}
		for(String s : map.keySet()) ans+=conbination(map.get(s));
		System.out.print(ans);
	}
	private static int conbination(Integer n) {
		if(n <= 1) return 0;
		return n*(n-1)/2;
	}
}

/*
2 3
1 3 2
12 50 31

1
*/