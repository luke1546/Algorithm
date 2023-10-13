import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int N = Integer.parseInt(br.readLine());	//전깃줄의 갯수
		int[] arr = new int[N];
		String str[] = br.readLine().split(" ");
		for(int i=0; i<N; i++)	arr[i] = Integer.parseInt(str[i]);
		int[] 최장증가수열 = new int[N];
		int[][] trace = new int[N][2];
		Arrays.fill(최장증가수열, Integer.MAX_VALUE);
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(최장증가수열, arr[i]);
			if(index < 0)	index = (index*-1)-1;
			최장증가수열[index] = arr[i];
			trace[i][0] = index;
			trace[i][1] = arr[i];
			max = Math.max(max, index);
		}
		int temp = max;
		for(int i=N-1; i>=0; i--) {
			if(trace[i][0] == temp) {
				dq.offer(trace[i][1]);
				temp--;
			}
		}
		sb.append(dq.size()+"\n");
		while(!dq.isEmpty())	sb.append(dq.pollLast()+" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
