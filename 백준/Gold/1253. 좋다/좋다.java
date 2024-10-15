import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			if(twoPointer(i)) cnt++;
		}
		System.out.println(cnt);
	}
	private static boolean twoPointer(int i) {
		int find = arr[i];
		int s = 0;
		int e = arr.length-1;
		while(s < e) {
			int sum = arr[s] + arr[e];
			if(sum > find) {
				e--;
			}else if(sum < find) {
				s++;
			}else {
				if(s == i) s++;
				else if(e == i) e--;
				else return true;
			}
		}
		return false;
	}
}
