import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int ans = 0;
		int left = 0;
		int right = Integer.MAX_VALUE;
		while(left <= right) {
			int mid = (left+right)/2;
			int cnt = 조카에게나눠주기(mid);
			if(cnt >= N) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(ans);
	}
	private static int 조카에게나눠주기(int mid) {
		if(mid == 0) return Integer.MAX_VALUE;
		int ans = 0;
		for(int x : list) {
			ans += x/mid;
		}
		return ans;
	}
}

/*
3 10
1 2 3 4 5 6 7 8 9 10

8
*/