import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			String s = Integer.toBinaryString(n);
			for(int i=s.length()-1; i>=0; i--) {
				if(s.charAt(i) == '1') sb.append(s.length()-i-1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
