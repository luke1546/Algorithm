import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegmentTree {
	static long[] segment;
	static int size, half, N, M, K;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		make();
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(Integer.parseInt(st.nextToken()) == 2)	query();
			else update();
		}
		System.out.println(sb.toString());
	}
	private static void update() {
		int b = Integer.parseInt(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		b+=(half-1);
		long dif = segment[b] - c;
		while(b>0) {
			segment[b]-=dif;
			b/=2;
		}
	}
	private static void query() {
		long answer=0;
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		b+=(half-1);
		c+=(half-1);
		while(c>=b) {
			if(b%2==1)	answer+=segment[b++];
			if(c%2==0)	answer+=segment[c--];
			b/=2;
			c/=2;
		}
		sb.append(answer + "\n");
	}
	private static void make() throws IOException {
		size = (int)(Math.pow(2,Math.ceil((Math.log(N) / Math.log(2)))))*2;
		half = size/2;
		segment = new long[size];
		for(int i=half; i<N+half; i++)	segment[i] = Long.parseLong(br.readLine());
		for(int i = size-1; i>0; i-=2)	segment[i/2] = segment[i]+segment[i-1];
	}
}

/*
bj_2042 구간 합 구하기
input:
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
answer:
17
12
 */