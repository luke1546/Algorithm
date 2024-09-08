import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			check(num);
		}
		System.out.print(sb);
	}
	private static void check(int num) {
		int cnt = 0, sum = 0;
		int i = 0;
		while(sum + i < num) {
			i++;
			sum+=i;
		}
		while(sum != 0) {
			if((num - sum) % i == 0) cnt++;
			sum-=i;
			i--;
		}
		sb.append(cnt-1).append("\n");
	}
}
