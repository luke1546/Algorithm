import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String s,t;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		s = br.readLine();
		t = br.readLine();
		sb.append(t);
		dfs(sb);
		System.out.println(ans);
	}
	private static void dfs(StringBuilder sb) {
		if(sb.toString().equals(s)) ans = 1;
		if(sb.length() == 0) return;
		if(sb.charAt(sb.length()-1) == 'A') {
			StringBuilder clone = new StringBuilder();
			clone.append(sb);
			clone.setLength(clone.length()-1);
			dfs(clone);
		}
		if(sb.charAt(0) == 'B') {
			StringBuilder clone = new StringBuilder();
			clone.append(sb);
			clone.delete(0, 1);
			clone.reverse();
			dfs(clone);
		}
	}
}

/*
BAB
BAABABAAB

1
*/