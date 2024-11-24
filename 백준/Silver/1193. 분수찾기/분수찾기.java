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
		int cnt = 1;
		while(cnt < N) {
			N-=cnt;
			cnt++;
		}
		if((cnt&1)==0) sb.append(N).append("/").append(cnt-N+1);
		else sb.append(cnt-N+1).append("/").append(N);
		System.out.println(sb);
	}
}
