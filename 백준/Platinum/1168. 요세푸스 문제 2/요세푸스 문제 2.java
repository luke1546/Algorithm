import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, rank, size, segment[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		rank = Integer.parseInt(st.nextToken());
		sb.append("<");
		int interval = rank-1;
		init();
		int jsphSize = N-1;
		query(1,1,size/2,rank);
		for(int i=0; i<N-1; i++) {
			rank = (rank+interval-1)%jsphSize+1;
			query(1,1,size/2,rank);
			jsphSize--;
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb.append(">").toString());
	}
	private static void query(int node, int s, int e, int rank) {
		segment[node]--;
		int m = (s+e)/2;
		if(s == e)	sb.append(node-size/2+1).append(", ");
		else if(segment[node*2] >= rank) query(node*2,s,m,rank);
		else query(node*2+1,m+1,e,rank - segment[node*2]);
	}
	private static void init() {
		size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))+1);
		segment = new int[size];
		for(int i=size/2; i<size/2+N; i++)	segment[i] = 1;
		for(int i=size-1; i>0; i-=2)	segment[i/2] = segment[i] + segment[i-1]; 
	}
}
