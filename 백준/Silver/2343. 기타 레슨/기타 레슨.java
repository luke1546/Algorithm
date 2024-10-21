import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int max = 0; // 레슨 길이 중 최대값
        int sum = 0; // 레슨 길이들의 합
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]); // 가장 긴 레슨
            sum += arr[i]; // 레슨 길이의 총합
		}
		int s = max;
		int e = sum;
		int min = Integer.MAX_VALUE;
		while(s<=e) {
			int m = s+(e-s)/2;
			int v = calc(m,arr);
			if(v <= M) {
				min = Math.min(min, m);
				e = m-1;;
			}
			else s = m+1;
		}
		System.out.println(min);
	}
	private static int calc(int m, int[] arr) {
		int cnt = 1;
		int temp = m;
		for(int i=0; i<N; i++) {
			if(temp-arr[i] < 0) {
				cnt++;
				temp = m;
			}
			temp-=arr[i];
		}
		return cnt;
	}
}

/*
9 3
1 2 3 4 5 6 7 8 9

17
*/