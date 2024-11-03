import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			boolean flag = false;
			long x = Long.parseLong(br.readLine());
			for(int j=2; j<1000000; j++) {
				if(x%j==0) {
					flag = true;
					break;
				}
			}
			if(flag) sb.append("NO");
			else sb.append("YES");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

/*
3
1000036000099
1500035500153
20000000000002

YES
NO
NO
*/