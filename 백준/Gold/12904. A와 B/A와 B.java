import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		String t = br.readLine();
		sb.append(t);
		while(sb.length() != s.length()) {
			if(sb.charAt(sb.length()-1) == 'A') sb.setLength(sb.length()-1);
			else {
				sb.setLength(sb.length()-1);
				sb.reverse();
			}
		}
		if(sb.toString().equals(s)) System.out.println(1);
		else	System.out.println(0);
	}
}

/*
B
ABBA

1
*/