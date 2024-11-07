import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine())/4;
		for(int i=0; i<n; i++) sb.append("long ");
		sb.append("int");
		System.out.println(sb);
	}
}
