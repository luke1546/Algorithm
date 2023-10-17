import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			double r = Math.abs(Double.parseDouble(st.nextToken()) - Double.parseDouble(st.nextToken()));
			double rs = Math.sqrt(r);
			double a = Math.floor(rs);
			double b = Math.ceil(rs);
			if(a==b) sb.append((long)(2*a-1)+"\n");
			else if(r < a*a+b) sb.append((long)(2*a)+"\n"); 
			else sb.append((long)(2*a+1)+"\n"); 
		}
		System.out.println(sb.toString());
	}
}
