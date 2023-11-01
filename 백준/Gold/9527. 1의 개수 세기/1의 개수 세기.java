import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long prefix[];
	public static void main(String[] args) throws IOException {
		int SIZE = 57;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long arr[] = new long[SIZE];
		prefix = new long[SIZE];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Long.parseLong(st.nextToken())-1;
		long b = Long.parseLong(st.nextToken());
		arr[1] = 1;
		prefix[1] = 1;
		long t = 1;
		for(int i=2; i<SIZE; i++) {
			arr[i] = arr[i-1]*2+t;
			t+=t;
			prefix[i] = prefix[i-1]+arr[i];
		}
		for(int i=SIZE-1; i>0; i--)	prefix[i] = prefix[i-1]+1;
		String sa = Long.toBinaryString(a);
		String sb = Long.toBinaryString(b);
//		System.out.println(count1(sb));
//		System.out.println(count1(sa));
		System.out.println(count1(sb) - count1(sa));
		//21
		//10101
	}

	private static long count1(String sb) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int index = 1;
		long ans = 0;
		long cnt = 0;
		for(int i=sb.length()-1; i>=0; i--) {
			if(sb.charAt(i)=='1') dq.offer(index);
			index++;
		}
		while(!dq.isEmpty()) {
			int t = dq.pollLast();
			long p = (long)(Math.pow(2, t-1)*cnt);
			ans += prefix[t]+p;
			cnt++;
		}
		return ans;
	}
}
