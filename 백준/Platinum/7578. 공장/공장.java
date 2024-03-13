import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, size, segment[], arr[];
	static long ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hm = new HashMap<>();
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++)	hm.put(Integer.parseInt(st.nextToken()), i+1);
		init();
		for(int i=0; i<n; i++) {
			int index = hm.get(arr[i]);
			update(1,1,size/2,index,1);
			ans += query(1,1,size/2,index+1,size/2);
		}
		System.out.println(ans);
	}
	private static void update(int node, int start, int end, int i, int diff) {
		if(start > i || end < i) return;
		if(start == i && end == i) {
			segment[node] += diff;
			return;
		}
		int mid = (start+end)/2;
		update(node*2, start, mid, i, diff);
		update(node*2+1, mid+1, end, i , diff);
		segment[node] = segment[node*2] + segment[node*2+1];
	}
	private static int query(int node, int start, int end, int a, int b) {
		if(start > b || end < a) return 0;
		if(a <= start && end <= b) return segment[node];
		int mid = (start+end)/2;
		return query(node*2, start, mid, a, b) + query(node*2+1, mid+1, end, a, b);
	}
	private static void init() {
		size = (int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))+1);
		segment = new int[size];
	}
}
