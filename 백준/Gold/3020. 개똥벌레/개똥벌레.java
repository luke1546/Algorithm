import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, H;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int arr1[] = new int[N/2];
		int arr2[] = new int[N/2];
		for(int i=0; i<N/2; i++) {
			arr1[i] = Integer.parseInt(br.readLine());
			arr2[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i=1; i<=H; i++) {
			int value = 이분탐색(arr1, i) + 이분탐색(arr2, H-i+1);
//			System.out.println(이분탐색(arr1, i) + " " + 이분탐색(arr2, H-i+1));
//			System.out.println(value);
			if(value < ans) {
				ans = value;
				cnt=1;
			}else if(value == ans) cnt++;
		}
		System.out.println(ans + " " + cnt);
		
	}
	public static int 이분탐색(int arr[], int x) {
		int s = 0;
		int e = arr.length -1;
		int find = -100;
		
		if(arr[e] < x) return 0;
		else if(arr[s] > x) return N/2;
		
		while(s <= e) {
			int m = (e+s)/2;
			if(x < arr[m]) {
				e = m-1;
				find = e;
			}else if(x > arr[m]){
				s = m+1;
			}else {
				e = m-1;
				find = e;
			}
		}
		return N/2-(find+1);
	}
}

/*
14 5
1
3
4
2
2
4
3
4
3
3
3
2
3
3

7 2
*/