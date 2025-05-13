import java.util.*;
import java.io.*;

public class Main {
	static int N, target, ans = 0, arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(target==0 ? ans-1 : ans);
	}
	private static void dfs(int cnt, int res) {
		if(cnt == N) { 
			if(res == target) ans++;
			return;
		}
		dfs(cnt+1, res+arr[cnt]);
		dfs(cnt+1, res);
	}
}

/*
5 0
-7 -3 -2 5 8

1
*/