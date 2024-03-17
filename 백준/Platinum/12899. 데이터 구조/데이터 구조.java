import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, size, segment[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		init();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 1) update(1,1,size/2,b);
			if(a == 2) query(1,1,size/2,b);
		}
		System.out.println(sb.toString());
	}
	private static void query(int node, int s, int e, int b) {
		segment[node]--;
		if(s == e) {
			sb.append(node-size/2+1).append("\n");
			return;
		}
		int m = (s+e)/2;
		if(segment[node*2] >= b)	query(node*2,s,m,b);
		else	query(node*2+1,m+1,e,b-segment[node*2]);
	}
	private static void update(int node, int s, int e, int b) {
		if(b < s || b > e) return;
		if(b == s && b == e) {
			segment[node]++;
			return;
		}
		int m = (s+e)/2;
		update(node*2,s,m,b);
		update(node*2+1,m+1,e,b);
		segment[node] = segment[node*2] + segment[node*2+1];
	}
	private static void init() {
		size = (int)Math.pow(2, Math.ceil(Math.log(2000000) / Math.log(2))+1);
		segment = new int[size];
		
	}
}


// 왼쪽은 작은 수, 오른쪽은 큰 수