import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int big = a>b ? a : b;
		int arr[] = new int[big*2+1];
		Arrays.fill(arr, -1);
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {a,0});
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			if(cur[0] > big*2 || cur[0] < 0) continue;
			if(arr[cur[0]] == -1 || arr[cur[0]] > cur[1]) arr[cur[0]] = cur[1];
			else continue;
			dq.offer(new int[] {cur[0]-1, cur[1]+1});
			dq.offer(new int[] {cur[0]+1, cur[1]+1});
			dq.offer(new int[] {cur[0]*2, cur[1]});
		}
		System.out.println(arr[b]);
	}
}
