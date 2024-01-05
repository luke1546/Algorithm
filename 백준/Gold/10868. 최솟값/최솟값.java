import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,size,half,segment[];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a+=(half-1);
			b+=(half-1);
			query(a,b);
		}
		System.out.println(sb.toString());
	}
	private static void query(int a, int b) {
		int min = Integer.MAX_VALUE;
		while(b>=a) {
			if(a%2==1) min = Math.min(min, segment[a++]);
			if(b%2==0) min = Math.min(min, segment[b--]);
			a/=2;
			b/=2;
		}
		sb.append(min + "\n");
	}
	private static void make() throws NumberFormatException, IOException {
		size = (int)Math.pow(2,Math.ceil(Math.log(N)/Math.log(2)))*2;
		half=size/2;
		segment = new int[size];
		Arrays.fill(segment, Integer.MAX_VALUE);
		for(int i=half; i<N+half; i++)	segment[i] = Integer.parseInt(br.readLine());
		for(int i=size-1; i>0; i-=2)	segment[i/2] = Math.min(segment[i-1], segment[i]);
	}
}
