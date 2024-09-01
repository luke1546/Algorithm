import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[], N, n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		n = Integer.parseInt(br.readLine());
		System.out.print(find());
	}
	private static int find() {
		int cnt = 0;
		int index = Arrays.binarySearch(arr, n);
		if(index >= 0) return cnt;
		index = (index * -1) -2;		
		int start = 0, end = 0;
		if(index < 0) {
			start = 1;
			end = arr[0]-1;
		}else if(index == N - 1) {
			return cnt;
		}else {
			start = arr[index]+1;
			end = arr[index+1]-1;
		}
		
		for(int i=start; i<end; i++) {
			for(int j=i+1; j<=end; j++) {
				if(n >= i && n <= j) cnt++;
			}
		}
		return cnt;
	}
}

/*
8
3 7 12 18 25 100 33 1000
59

1065
*/