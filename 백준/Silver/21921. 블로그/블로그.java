import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<M; i++) {
			int n = Integer.parseInt(st.nextToken());
			dq.offer(n);
			sum+=n;
		}
		int max = sum, cnt = 1;
		while(st.hasMoreTokens()) {
			int c = dq.poll();
			int n = Integer.parseInt(st.nextToken());
			dq.offer(n);
			sum = sum - c + n;
			if(sum > max) {
				max = sum;
				cnt = 1;
			}
			else if(sum == max) cnt++;
		}
		if(sum == 0) System.out.println("SAD");
		else System.out.println(max + "\n" + cnt);
	}
}
/*
5 2
1 4 2 5 1

7
1
*/
