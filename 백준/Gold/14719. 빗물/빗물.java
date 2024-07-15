import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int arr[], dirs[] = {-1,1}, W,H;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[W];
		int ans = 0;
		for(int i=0; i<W; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<W-1; i++) {
			int left = 0;
			int right = 0;
			for(int j=0; j<i; j++) {
				left = Math.max(left, arr[j]);
			}
			for(int k=i+1; k<W; k++) {
				right = Math.max(right,  arr[k]);
			}
			if(arr[i] < left && arr[i] < right) {
				ans+=Math.min(left, right) - arr[i];
			}
		}
		System.out.println(ans);
	}
}

/*
4 4
3 0 1 4

5
*/