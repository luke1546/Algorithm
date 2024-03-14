import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, size, segment[];
	static boolean lazy[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x == 0) update(1,1,size/2,a,b);
			if(x == 1) sb.append(query(1,1,size/2,a,b)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int query(int node, int start, int end, int a, int b) {
		propagation(node,start,end);
		if(start > b || end < a) return 0;
		if(start >= a && end <= b) return segment[node];
		int mid = (start+end)/2;
		return query(node*2,start,mid,a,b) + query(node*2+1,mid+1,end,a,b);
	}
	private static void update(int node, int start, int end, int a, int b) {
		propagation(node,start,end);
		if(start > b || end < a) return;
		if(a <= start && end <= b) {
			segment[node] = (end-start+1) - segment[node];
			if(start != end) {
				lazy[node*2] = !lazy[node*2];
				lazy[node*2+1] = !lazy[node*2+1];
			}
			return;
		}else {
			int mid = (start+end)/2;
			update(node*2,start,mid,a,b);
			update(node*2+1,mid+1,end,a,b);
		}
		segment[node] = segment[node*2] + segment[node*2+1];
	}
	
	private static void propagation(int node, int start, int end) {
		if(lazy[node])	{
			segment[node] = (end-start+1) - segment[node];
			lazy[node] = !lazy[node];
			if(start != end) {
				lazy[node*2] = !lazy[node*2];
				lazy[node*2+1] = !lazy[node*2+1];
			}
		}
	}
	private static void init() {
		size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
		segment = new int[size];
		lazy = new boolean[size];
	}
}
