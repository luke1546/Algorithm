import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		HashSet<Integer> hs = new HashSet<>();
		Deque<Integer> dq = new ArrayDeque<>();
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int count[] = new int[d+1];
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int n = arr[i];
			dq.offer(n);
			hs.add(n);
			count[n]++;
			if(dq.size() > k) {
				int p = dq.poll();
				count[p]--;
				if(count[p] == 0) hs.remove(p);
			}
			hs.add(c);
			max = Math.max(max, hs.size());
		}
		
		for(int i=0; i<N; i++) {
			int n = arr[i];
			dq.offer(n);
			hs.add(n);
			count[n]++;
			if(dq.size() > k) {
				int p = dq.poll();
				count[p]--;
				if(count[p] == 0) hs.remove(p);
			}
			hs.add(c);
			max = Math.max(max, hs.size());
		}
		System.out.println(max);
	}
}

/*
8 30 4 30
7
9
7
30
2
7
9
25

5
*/