import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class Lazy{
		long v;
		long lazy;
		
		public Lazy(long lazy, long v) {
			this.v = v;
			this.lazy = lazy;
		}
		
		public String toString() {
			return lazy + " " + v;
		}
	}
	static int N, K, M, size;
	static Lazy[] segment;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		init();
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				long d = Long.parseLong(st.nextToken());
				update(1,1,size/2,b,c,d);
			}else if(a == 2) {
				sb.append(query(1,1,size/2,b,c)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static long query(int node, int start, int end, int a, int b) {
		propagation(node, start, end);
		if(b < start || a > end) return 0;
		else if(start >= a && end <= b) return segment[node].v;
		int mid = (start + end) / 2;
		return query(node*2, start, mid, a , b) + query(node*2+1, mid+1, end, a, b);
	}

	private static void propagation(int node, int start, int end) {
		long lazy = segment[node].lazy;
		segment[node].v += lazy * (end - start + 1);
		if(start != end) {
			segment[node*2].lazy += lazy;
			segment[node*2+1].lazy += lazy;
		}
		segment[node].lazy = 0;
	}

	private static void update(int node, int start, int end, int a, int b, long diff) {
		propagation(node, start, end);
		if(b < start || a > end) return;
		else if(start >= a && end <= b) {
			segment[node].v += diff*(end-start+1);
			if(start != end) {
				segment[node*2].lazy += diff;
				segment[node*2+1].lazy += diff;
			}
			return;
		}
		int mid = (start + end) / 2;
		update(node*2, start, mid, a, b, diff);
		update(node*2+1, mid+1, end, a, b, diff);
		segment[node] = sum(segment[node*2], segment[node*2+1]);
	}
	

	private static void init() throws NumberFormatException, IOException {
		size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
		segment = new Lazy[size];
		segment[0] = new Lazy(0,0);
		for(int i=size/2; i<size/2+N; i++) {
			long v = Long.parseLong(br.readLine());
			segment[i] = new Lazy(0,v);
		}
		for(int i=size/2+N; i<size; i++) segment[i] = new Lazy(0,0);
		for(int i=size-1; i>1; i-=2) segment[i/2] = sum(segment[i],segment[i-1]);
	}
	
	public static Lazy sum(Lazy l1, Lazy l2) {
		return new Lazy(l1.lazy + l2.lazy, l1.v + l2.v);
	}
}
