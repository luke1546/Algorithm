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
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append("Case ").append(i+1).append(": ").append(a+b).append("\n");
		}
		System.out.println(sb);
	}
}
/*
5
1 2
1 3
3 5
2 6
3 4

Case 1: 3
Case 2: 4
Case 3: 8
Case 4: 8
Case 5: 7
*/