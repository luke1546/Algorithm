import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int cnt[] = new int[100001];
		int max = 0;
		int start = 0;
		for(int i=0; i<N; i++) {
			cnt[arr[i]]++;
			if(cnt[arr[i]] > K) {
				max = Math.max(max, i-start);
				for(int j=start; j<i; j++) {
					cnt[arr[j]]--;
					if(arr[j] == arr[i]) {
						start = j+1;
						break;
					}
				}
			}
		}
		max = Math.max(N-start, max);
		System.out.println(max);
	}
}


/*
9 2
3 2 5 5 6 4 4 5 7

7
*/