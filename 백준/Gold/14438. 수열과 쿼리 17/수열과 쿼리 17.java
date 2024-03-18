import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, size, segment[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		init();
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(q==1) update(1,1,size/2,a,b);
			else sb.append(query(1,1,size/2,a,b)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void update(int node, int s, int e, int a, int v) {
		if(a < s || a > e) return;
		else if(s == a && a == e) {
			segment[node] = v;
			return;
		}
		int m = (s+e)/2;
		update(node*2,s,m,a,v);
		update(node*2+1,m+1,e,a,v);
		segment[node] = Math.min(segment[node*2], segment[node*2+1]);
	}
	private static int query(int node, int s, int e, int a, int b) {
		if(b < s || e < a) return Integer.MAX_VALUE;
		if(a <= s && e <= b) return segment[node];
		int m = (s+e)/2;
		return Math.min(query(node*2,s,m,a,b) , query(node*2+1,m+1,e,a,b));
	}
	private static void init() throws IOException {
		size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))+1);
		st  = new StringTokenizer(br.readLine(), " ");
		segment = new int[size];
		for(int i=size/2; i<size/2+N; i++) segment[i] = Integer.parseInt(st.nextToken());
		for(int i=size/2+N; i<size; i++) segment[i] = Integer.MAX_VALUE;
		for(int i=size-1; i>0; i-=2)	segment[i/2] = Math.min(segment[i], segment[i-1]);
	}
}
