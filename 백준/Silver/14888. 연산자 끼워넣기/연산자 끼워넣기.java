import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int arr[], op[], selected[];
	static int N, opList[], max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		visit = new boolean[N-1];
		selected = new int[N-1];
		opList = new int[N-1];
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
		int index = 0;
		for(int i=0; i<N-1; i++) {
			while(op[index] == 0) {
				index++;
			}
			op[index]--;
			opList[i] = index;
			//index 정보
			// 0 : +, 1 : -, 2 : * , 3 : /
		}
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void perm(int cnt) {
		if(cnt == N-1) {
			int res = calc(selected);
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		for(int i=0; i<N-1; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			selected[cnt] = i;
			perm(cnt+1);
			visit[i] = false;
		}
	}
	private static int calc(int[] selected) {
		int res = arr[0];
		for(int i=0; i<selected.length; i++) {
			int op = opList[selected[i]];
			switch(op) {
			case 0:
				res+=arr[i+1];
				break;
			case 1:
				res-=arr[i+1];
				break;
			case 2:
				res*=arr[i+1];
				break;
			case 3:
				res/=arr[i+1];
				break;
			}
		}
		return res;
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