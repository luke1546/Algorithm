import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, size, segment[], arr[];
	static HashMap<Integer, Integer> hm = new HashMap<>();
	static HashMap<Integer, ArrayList<Integer>> hm2 = new HashMap<>();
	static HashMap<Integer, Integer> hm3 = new HashMap<>();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)	{
			arr[i] = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(arr[i]))	hm.put(arr[i], i+1);
			else if(hm.get(arr[i]) != -1){
				ArrayList<Integer> list = new ArrayList<>();
				list.add(hm.get(arr[i]));
				list.add(i+1);
				hm2.put(arr[i], list);
				hm.put(arr[i],-1);
			}else {
				hm2.get(arr[i]).add(i+1);
			}
		}
		
		Arrays.sort(arr);
		init();
		long ans = 0;
		for(int i=0; i<N; i++) {
			if(hm.get(arr[i]) != -1) {
				update(1,1,size/2,hm.get(arr[i]));
				ans += query(1,1,size/2,hm.get(arr[i])+1,N);
			}else if(hm3.containsKey(arr[i])){
				update(1,1,size/2,hm2.get(arr[i]).get(hm3.get(arr[i])));
				ans += query(1,1,size/2,hm2.get(arr[i]).get(hm3.get(arr[i]))+1,N);
				hm3.put(arr[i], hm3.get(arr[i])+1); 
			}
			else {
				update(1,1,size/2,hm2.get(arr[i]).get(0));
				ans += query(1,1,size/2,hm2.get(arr[i]).get(0)+1,N);
				hm3.put(arr[i], 1); 
			}
		}
		System.out.println(ans);
	}
	private static int query(int n, int s, int e, int a, int b) {
		if(b < s || a > e) return 0;
		if(a <= s && e <= b) return segment[n];
		int m = (s+e)/2;
		return query(n*2,s,m,a,b) + query(n*2+1,m+1,e,a,b);
	}
	private static void update(int n, int s, int e, int i) {
		if(i < s || i > e) return;
		if(i == s && i == e) {
			segment[n]++;
			return;
		}
		int m = (s+e)/2;
		update(n*2,s,m,i);
		update(n*2+1,m+1,e,i);
		segment[n] = segment[n*2] + segment[n*2+1];
	}
	private static void init() {
		size = (int)Math.pow(2,Math.ceil(Math.log(N) / Math.log(2)) + 1);
		segment = new int[size];
		
	}
}
