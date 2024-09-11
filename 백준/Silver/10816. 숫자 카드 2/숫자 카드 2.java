import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(hm.containsKey(x)) hm.put(x, hm.get(x)+1);
            else hm.put(x,1);
		}
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int x = Integer.parseInt(st.nextToken());
			sb.append(hm.get(x) == null ? 0 : hm.get(x)).append(" ");
		}
		System.out.print(sb);
	}
}

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10

3 0 0 1 2 0 0 2
*/