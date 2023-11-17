import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, Q, size;
	static long segment[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		makeSegment();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=size>>1; i<(size>>1)+N; i++)
			segment[i] = Integer.parseInt(st.nextToken());
		init();
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(query(x,y)).append("\n");
			update(a,b);
		}
		System.out.println(sb.toString());
	}

	private static void update(int a, int b) {
		a = a+(size>>1)-1;
		long dif = b-segment[a];
		while(a>0) {
			segment[a]+=dif;
			a>>=1;
		}
	}

	private static long query(int x, int y) {
		long ans = 0;
		if (x>y) {
			int temp = x;
			x = y;
			y = temp;
		}
		x = x+(size>>1)-1;
		y = y+(size>>1)-1;
		while(y>=x) {
			if(x%2==1) ans+=segment[x];
			if(y%2==0) ans+=segment[y];
			x=(x+1)>>1;
			y=(y-1)>>1;
		}
		return ans;
	}

	private static void init() {
		for(int i = size-1; i>1; i--)
			segment[i/2] += segment[i];
	}

	private static void makeSegment() {
		size = (int)(Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))))<<1;
		segment = new long[size];
	}
}
