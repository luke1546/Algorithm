import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int tc=0; tc<N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int rank[] = new int[M];
			int arr[] = new int[M];
			for(int i=0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<M; i++) rank[i] = Arrays.binarySearch(arr, arr[i]);
			int hash = Arrays.hashCode(rank);
            map.put(hash, map.getOrDefault(hash, 0)+1);
		}
		for(int key : map.keySet()) ans+=conbination(map.get(key));
		bw.write(String.valueOf(ans));
		bw.flush();
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