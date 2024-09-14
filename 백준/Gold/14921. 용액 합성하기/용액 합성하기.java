import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[];
	static int min = Integer.MAX_VALUE, ans = 0, N = 0;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(arr, -arr[i]);
			if(index < 0) index = (index*-1)-1;
			if(index == i) {
				min(i, index-1);
				min(i, index+1);
			}else if(index+1 == i) {
				min(i, index-1);
				min(i, index);
			}else if(index-1 == i) {
				min(i, index);
				min(i, index+1);
			}
			else {
				min(i,index);
				min(i,index+1);
				min(i, index-1);
			}
		}
		System.out.println(ans);
	}
	private static void min(int i, int j) {
		if(j >= 0 && j < N) {
			int v = Math.abs(arr[i] + arr[j]);
			if(min > v) {
				min = v;
				ans = arr[i] + arr[j];
			}
		}
	}
}
