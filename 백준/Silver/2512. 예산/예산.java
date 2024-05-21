import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		Deque<Integer> dq = new ArrayDeque<>();
		int end = 0, start = 0;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int budget = Integer.parseInt(br.readLine());
		for(int i : arr) end = Math.max(end, i);
		
		int answer = 0;
		while(start <= end) {
			int sum = 0;
			int mid = (start+end)/2;
			for(int i : arr) sum += Math.min(mid, i); 
			if(sum <= budget) {
				start = mid+1;
				answer = mid;
			}
			else end = mid-1;
		}
		System.out.println(answer);
	}
}

/*
4
120 110 125 150
485

127
*/