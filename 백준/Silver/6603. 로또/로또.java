import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int selected[] = new int[6];
	static int R = 6, N, arr[];
	public static void main(String[] args) throws IOException {
		
		while(true)
		{
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			comb(0,0);
			sb.append("\n");
		}
		sb.setLength(sb.length()-2);
		System.out.print(sb);
	}
	private static void comb(int start, int cnt) {
		if(cnt == R)
		{
			for(int i=0; i<R; i++)
				sb.append(selected[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			selected[cnt] = arr[i];
			comb(i+1, cnt+1);
		}
	}
}
/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0

1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7

1 2 3 5 8 13
1 2 3 5 8 21
1 2 3 5 8 34
1 2 3 5 13 21
1 2 3 5 13 34
1 2 3 5 21 34
1 2 3 8 13 21
1 2 3 8 13 34
1 2 3 8 21 34
1 2 3 13 21 34
1 2 5 8 13 21
1 2 5 8 13 34
1 2 5 8 21 34
1 2 5 13 21 34
1 2 8 13 21 34
1 3 5 8 13 21
1 3 5 8 13 34
1 3 5 8 21 34
1 3 5 13 21 34
1 3 8 13 21 34
1 5 8 13 21 34
2 3 5 8 13 21
2 3 5 8 13 34
2 3 5 8 21 34
2 3 5 13 21 34
2 3 8 13 21 34
2 5 8 13 21 34
3 5 8 13 21 34
*/