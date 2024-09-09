import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		long end = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		long start = 0;
		long ans = 0;
		end*=2;
		while(start <= end) {
			long mid = (start+end)/2;
			if(canSplit(mid, K)) {
				start = mid+1;
				ans = Math.max(ans, mid);
			}else end = mid-1;
		}
		System.out.print(ans);
	}
	private static boolean canSplit(long mid, int k) {
		int cnt = 0;
		for(int i=0; i<arr.length; i++) cnt += arr[i]/mid;
		if(cnt >= k) return true;
		return false;
	}
}

/*
4 11
802
743
457
539

200
*/