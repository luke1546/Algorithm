import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int money[] = new int[4];
		money[0] = 25;
		money[1] = 10;
		money[2] = 5;
		money[3] = 1;
		for(int i=0; i<N; i++) {
			int change = Integer.parseInt(br.readLine());
			for(int j=0; j<money.length; j++) {
				sb.append(change/money[j]).append(" ");
				change%=money[j];
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

/*
3
124
25
194

4 2 0 4
1 0 0 0
7 1 1 4
*/