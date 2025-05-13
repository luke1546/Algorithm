import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int arr[], op[], selected[];
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		selected = new int[N-1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			int x = Integer.parseInt(st.nextToken());
			op[i] = x;
		}
		dfs(0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int cnt, int res) 
	{
		if(cnt == N-1) 
		{
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		for(int i=0; i<4; i++) 
		{
			if(op[i] == 0) continue;
			op[i]--;
			int next = res;
			switch(i) 
			{
			case 0:
				next+=arr[cnt+1];
				break;
			case 1:
				next-=arr[cnt+1];
				break;
			case 2:
				next*=arr[cnt+1];
				break;
			case 3:
				next/=arr[cnt+1];
				break;
			}
			dfs(cnt+1, next);
			op[i]++;
		}
	}
}

/*
2
5 6
0 0 1 0
+ - * /
30
30
*/