import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int max = Integer.MIN_VALUE, N, arr[], selected[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		selected = new int[N];
		visit = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(max);
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			max = Math.max(max, calc(selected));
			return;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			selected[cnt] = arr[i];
			perm(cnt+1);
			visit[i] = false;
		}
	}
	private static int calc(int[] cur) {
		int ans = 0;
		for(int i=0; i<N-1; i++) {
			ans += Math.abs(cur[i] - cur[i+1]);
		}
		return ans;
	}
}
