import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		HashMap<Long,Integer> hm = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] countries = new long[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long n = Long.parseLong(st.nextToken());
			countries[i][0] = n;
			for(int j=2; j>=0; j--) {
				long l = Long.parseLong(st.nextToken());
				if(j != 0) l *= (long)Math.pow(1000000, j);
				countries[i][1] += l;
			}
			if(hm.containsKey(countries[i][1])) hm.put(countries[i][1], hm.get(countries[i][1])+1);
			else hm.put(countries[i][1], 0);
		}
		Arrays.sort(countries, new Comparator<long[]>() {
			@Override
			public int compare(long[] a, long[] b) {
				return Long.compare(b[1], a[1]);
			}
		});
		int rank = 0;
		for(int i=0; i<N; i++) {
			if(K == countries[i][0]) rank = i+1;
		}
		rank -= hm.get(countries[rank-1][1]);
		System.out.println(rank);
	}
	
	
}




/*
4 3
1 1 2 0
2 0 1 0
3 0 1 0
4 0 0 1
 */