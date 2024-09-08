import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) check(Integer.parseInt(br.readLine()));
		System.out.print(sb);
	}
	
	private static void check(int num) {
		int i = 0, cnt = 0, sum = 0;
		while(sum + i++ < num) sum+=i;
		while(sum != 0) {
			if((num - sum) % --i == 0) cnt++;
			sum-=i;
		}
		sb.append(cnt-1).append("\n");
	}
}