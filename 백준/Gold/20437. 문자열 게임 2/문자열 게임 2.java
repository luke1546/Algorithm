import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> dq;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			int k = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int arr[] = new int[26];
			boolean check[] = new boolean[26];
			for(int i=0; i<str.length(); i++) arr[str.charAt(i)-'a']++;
			
			for(int i=0; i<str.length(); i++) {
				int index = str.charAt(i)-'a';
				if(check[index] || arr[index] < k) continue;
				check[index] = true;
				dq = new ArrayDeque<>();
				dq.offer(i);
				for(int j=i+1; j<str.length(); j++) {
					if(dq.size() == k) {
						min = Math.min(min, dq.peekLast()-dq.peekFirst()+1);
						max = Math.max(max, dq.peekLast()-dq.peekFirst()+1);
						dq.poll();
					}
					if(str.charAt(j)-'a' == index) {
						dq.offer(j);
					}
				}
				if(dq.size() == k) {
					min = Math.min(min, dq.peekLast()-dq.peekFirst()+1);
					max = Math.max(max, dq.peekLast()-dq.peekFirst()+1);
					dq.poll();
				}
			}
			
			if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) sb.append(-1);
			else sb.append(min).append(" ").append(max);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
