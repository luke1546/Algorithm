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
		int sum = 0;
		int cnt = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n==1) {
				cnt++;
				sum+=cnt;
			}else cnt=0;
		}
		System.out.println(sum);
	}
}
