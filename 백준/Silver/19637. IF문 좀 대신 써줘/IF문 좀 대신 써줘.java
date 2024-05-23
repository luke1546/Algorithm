import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		HashMap<Integer, String> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int v = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(v)) hm.put(v, s);
			arr[i] = v;
		}
		Arrays.sort(arr);
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(br.readLine());
			int index = Arrays.binarySearch(arr, key);
			if(index >= 0) sb.append(hm.get(arr[index])).append("\n");
			else sb.append(hm.get(arr[index*-1-1])).append("\n");
		}
		System.out.println(sb.toString());
	}
}

/*
3 8
WEAK 10000
NORMAL 100000
STRONG 1000000
0
9999
10000
10001
50000
100000
500000
1000000

WEAK
WEAK
WEAK
NORMAL
NORMAL
NORMAL
STRONG
STRONG
*/