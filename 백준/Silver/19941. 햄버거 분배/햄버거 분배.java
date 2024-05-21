import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int ans = 0;
		ArrayDeque<Integer> H = new ArrayDeque<>();
		ArrayDeque<Integer> P = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'H') H.offer(i);
			else P.offer(i);
		}
		while(!P.isEmpty()) {
			int p = P.poll();
			while(!H.isEmpty()) {
				int h = H.peek();
				if(Math.abs(p-h) <= K) {
					ans++;
					H.poll();
					break;
				}else if(h > p) break;
				else if(h < p) H.poll();
			}
		}
		
		System.out.println(ans);
	}
}


/*
20 1
HHPHPPHHPPHPPPHPHPHP

8

20 2
HHHHHPPPPPHPHPHPHHHP

7
*/