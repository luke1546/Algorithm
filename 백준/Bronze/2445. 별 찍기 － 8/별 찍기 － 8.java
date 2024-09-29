import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<=i; j++) sb.append("*");
			for(int j=0; j<2*(N-1-i); j++) sb.append(" ");
			for(int j=0; j<=i; j++) sb.append("*");
			sb.append("\n");
		}
		
		for(int i=0; i<N*2; i++) sb.append("*");
		sb.append("\n");
		
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N-1; j++) sb.append("*");
			for(int j=0; j<2*(i+1); j++) sb.append(" ");
			for(int j=i; j<N-1; j++) sb.append("*");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}