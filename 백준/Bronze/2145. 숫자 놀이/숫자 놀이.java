import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			while(n >= 10) {
				n = play(n);
			}
			sb.append(n).append("\n");
		}
		System.out.print(sb);
	}
	private static int play(int n) {
		int x = 0;
		while(n!=0) {
			x += n%10;
			n/=10;
		}
		return x;
	}
}

/*
673
51
1000
99
0

7
6
1
9
*/