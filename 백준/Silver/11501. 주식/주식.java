import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			long sum=0;
			int arr[] = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
			for(int i=N-1; i>=0; i--) {
				if(arr[i] > max) max = arr[i];
				else sum+=max-arr[i];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}


/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2


0
10
5
*/