import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		while(true) {
			int cnt = 0;
			String str = br.readLine();
			if(str.equals("#")) break;
			str = str.toLowerCase();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}

/*
How are you today?
Quite well, thank you, how about yourself?
I live at number twenty four.
#

7
14
9
*/