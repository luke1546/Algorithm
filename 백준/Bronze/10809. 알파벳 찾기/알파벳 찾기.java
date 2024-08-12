import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		char c = 'a';
		for(int i=0; i<26; i++) {
			sb.append(str.indexOf(c)).append(" ");
			c++;
		}
		System.out.println(sb);
	}
}

/*
baekjoon

1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
*/