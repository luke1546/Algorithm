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
		for(int tc=0; tc<N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			int arr[] = new int[M];
			for(int i=0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<M; i++) sb.append(Arrays.binarySearch(arr, arr[i])).append(" ");
			String str = sb.toString();
			if(map.containsKey(str)) map.put(str, map.get(str)+1);
			else map.put(str, 1);
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