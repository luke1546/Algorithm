import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long max = Integer.MIN_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long s = 0;
		long e = 2000000000;
		while(s <= e) {
			long mid = (s+e)/2;
			long get = check(mid);
//			System.out.println(mid + " " + get);
			if(get >= M) {
				max = Math.max(max, mid);
				s=mid+1;
			}else {
				e = mid-1;
			}
		}
		System.out.println(max);
	}

	private static long check(long mid) {
		long x = 0;
		for(int n : arr) {
			if(mid < n) x+=(n-mid);
		}
		return x;
	}
}
