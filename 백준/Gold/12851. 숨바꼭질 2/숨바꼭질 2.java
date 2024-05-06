import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static boolean visit[];
	static Deque<int[]> dq = new ArrayDeque<>();
	static int min=Integer.MAX_VALUE,ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		visit = new boolean[(N+K)*5+1];
		visit[N] = true;
		dq.offer(new int[] {N,K,0});
		bfs(N,K,0);
		System.out.println(min+"\n"+ans);
	}
	private static void bfs(int n, int k, int depth) {
		// TODO Auto-generated method stub
		while(!dq.isEmpty()) {
			n = dq.peek()[0];
			visit[n] = true;
			k = dq.peek()[1];
			depth = dq.poll()[2];
//			System.out.println(depth + " " + n);
			if(n==k) {
				min = Math.min(min, depth);
				if(depth == min) {
					ans++;
					continue;
				}
				else {
					break;
				}
			}
			if(n!=0 && !visit[n-1]) {
//				visit[n-1] = true;
				dq.offer(new int[] {n-1,k,depth+1});
			}
			if(n > k*2 || n < 0)
				continue;
			if(!visit[n+1]) {
//				visit[n+1] = true;
				dq.offer(new int[] {n+1,k,depth+1});
			}
			if(!visit[n*2]) {
//				visit[n*2] = true;
				dq.offer(new int[] {n*2,k,depth+1});
			}
		}
	}
}
