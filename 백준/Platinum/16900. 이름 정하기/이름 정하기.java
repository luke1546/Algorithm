import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long ans = 0;
		String s = st.nextToken();
		long K = Long.parseLong(st.nextToken());
		int table[] = new int[s.length()];
		int j = 0;
		for(int i=1; i<s.length(); i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = table[j-1];
			if(s.charAt(i) == s.charAt(j)) table[i] = ++j;
		}
		System.out.println((s.length() - table[table.length-1]) * (K-1) + s.length());
	}
}

/*
ada 3

7
*/