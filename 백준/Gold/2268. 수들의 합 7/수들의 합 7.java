import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] segment;
	static int N, M, size;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		init();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) update(1,1,N,b,c);
			else {
				if(b>c) sb.append(query(1,1,N,c,b)).append("\n");
				else sb.append(query(1,1,N,b,c)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static long query(int node, int s, int e, int a, int b) {
		if(b < s || a > e) return 0;
		else if(a <= s && b >= e) return segment[node];
		int mid = (s+e)/2;
		return query(node*2, s, mid, a, b) + query(node*2+1, mid+1, e, a, b);
	}

	private static long update(int node, int s, int e, int i, int v) {
		if(s > i || e < i) return segment[node];
		else if(s==i && e==i) return segment[node]=v;
		int mid = (s+e)/2;
		return segment[node] = update(node*2,s,mid,i,v) + update(node*2+1,mid+1,e,i,v);
	}
	
	
	
	private static void init() {
		size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
		segment = new long[size];
	}
}

