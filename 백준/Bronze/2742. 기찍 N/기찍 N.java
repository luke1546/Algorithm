import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) sb.append(N-i).append("\n");
		System.out.println(sb);
	}
}
