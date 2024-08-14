import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		boolean[] decimal = new boolean[1001];
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		st = new StringTokenizer(br.readLine());
		decimal[0] = true;
		decimal[1] = true;
		for(int i=2; i<=33; i++) {
			int x = i*2;
			while(x<=1000) {
				decimal[x] = true;
				x+=i;
			}
		}
		for(int i=0; i<N; i++) if(!decimal[Integer.parseInt(st.nextToken())]) count++;
		System.out.println(count);
	}
}
