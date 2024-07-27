import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String A = br.readLine();
		int ans = 0;
		sb.append(br.readLine());
		sb.append(sb);
		sb.setLength(sb.length()-1);
		String B = sb.toString();
		int[] fail = new int[A.length()];
		
		int j = 0;
		for(int i=1; i<A.length(); i++) {
			while(j>0 && A.charAt(i) != A.charAt(j)) j = fail[j-1];
			if(A.charAt(i) == A.charAt(j)) fail[i] = ++j;
		}
		j = 0;
		for(int i=0; i<B.length(); i++) {
			while(j > 0 && A.charAt(j) != B.charAt(i)) j = fail[j-1];
			if(A.charAt(j) == B.charAt(i)) j++;
			if(j == A.length()) {
				j = fail[j-1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}
