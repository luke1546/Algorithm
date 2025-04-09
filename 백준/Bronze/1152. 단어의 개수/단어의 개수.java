import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int ans = 0;
		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			st.nextToken();
			ans++;
		}
		System.out.println(ans);
	}
}
