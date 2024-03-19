import java.util.*;
import java.io.*;

public class Main{
	static int N, size, segment[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		ArrayList<int[]> al = new ArrayList<>();
		for(int i=0; i<N; i++)	al.add(new int[] {i+1,Integer.parseInt(br.readLine())});
		Collections.sort(al,(o1,o2) -> o1[1]-o2[1]);
		for(int i=0; i<N; i++)	al.get(i)[1] = i+1;
		Collections.sort(al,(o1,o2) -> o1[0]-o2[0]);
		init();
		for(int i=0; i<N; i++) {
			sb.append(i+1-query(1,1,size/2,al.get(i)[1])).append("\n");
			update(1,1,size/2,al.get(i)[1]);
		}
		System.out.println(sb.toString());
	}
	private static void update(int n, int s, int e, int v) {
		if(v < s || v > e) return;
		if(v == s && v == e) {
			segment[n] = 1;
			return;
		}
		int m = (s+e)/2;
		update(n*2,s,m,v);
		update(n*2+1,m+1,e,v);
		segment[n] = segment[n*2] + segment[n*2+1];
	}
	private static int query(int n, int s, int e, int v) {
		if(v < s) return 0;
		if(e < v) return segment[n];
		if(segment[n] == 0) return 0;
		int m = (s+e)/2;
		return query(n*2,s,m,v) + query(n*2+1,m+1,e,v);
	}
	private static void init() {
		size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)) + 1);
		segment = new int[size];
	}
}