import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String line;
		while((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken())+1;
			int s = Integer.parseInt(st.nextToken());
			sb.append(s/n).append("\n");
		}
		System.out.println(sb);
	}
}
/*
1 100
2 7
10 9
10 10

50
2
0
0
*/
