import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long segment[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		makeSegment(N);
		int size = segment.length;
		for(int i=size/2; i<size/2 + N; i++)
			segment[i] = Long.parseLong(br.readLine());
		
		for(int i=size-1; i>1; i--)
			segment[i/2]+=segment[i];
		
		for(long i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				int index = (b-1+size/2);
				long dif = c - segment[index];
				while(index > 0) {
					segment[index]+=dif;
					index/=2;
				}
			}else {
				int start = (b-1+size/2);
				int end = (int) (c-1+size/2);
				long ans = 0;
				while(end >= start) {
					if(start%2==1)	ans+=segment[start];
					if(end%2==0) ans+=segment[end];
					start = (start+1)/2;
					end = (end-1)/2;
				}
				sb.append(ans).append("\n");
			}
		}
		System.out.print(sb.toString());
	}


	private static void makeSegment(int N) {
		segment = new long[(int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)))*2];
	}
}
