import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				sb.append(" ");
			}
			for(int j=N-1; j>=i; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}


/*
5

*****
 ****
  ***
   **
    *
*/