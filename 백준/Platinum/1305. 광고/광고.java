import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int j = 0;
		int fail[] = new int[N];
		for(int i=1; i<s.length(); i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = fail[j-1];
			if(s.charAt(i) == s.charAt(j)) fail[i] = ++j;
		}
		System.out.println(N - fail[s.length()-1]);
	}
}

/*
5
aaaaa

1
*/