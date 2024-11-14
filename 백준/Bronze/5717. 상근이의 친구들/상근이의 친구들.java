import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		while(true) {
		st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0) {
				System.out.print(sb);
				break;
			}
			else {
				sb.append(a+b).append("\n");
			}
		}
	}
}
/*
2 2
2 3
5 5
1 1
0 0

4
5
10
2
*/
