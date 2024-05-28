import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int max = 0, index = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o2[1]-o1[1]);
		boolean flag = false;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1,o2) -> o1[0]-o2[0]);
		for(int i=0; i<N; i++) {
			if(max < arr[i][1]) {
				max = arr[i][1];
				index = i;
			}
		}
		for(int i=index; i<N; i++) pq.offer(new int[] {arr[i][0],arr[i][1]});
		int ans = max;
//		if(arr[0][1] != max) ans += max;
		int temp = arr[0][1];
		for(int i=1; i<N; i++) {
			if(arr[i][1] == max || arr[i-1][1] == max) {
				if(arr[i-1][1] != max) ans += temp * (arr[i][0] - arr[i-1][0]); 
				break;
			}
			ans += temp * (arr[i][0] - arr[i-1][0]);
			if(arr[i][1] > temp) temp = arr[i][1];
		}
		int before[] = pq.poll();
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			if(cur[0] > before[0]) {
				ans += (cur[0] - before[0]) * cur[1];
				before = cur;
			}
		}
		System.out.println(ans);
	}
}

/*
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6

98
*/