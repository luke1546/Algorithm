import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
		}
		System.out.println(sb);
	}
}