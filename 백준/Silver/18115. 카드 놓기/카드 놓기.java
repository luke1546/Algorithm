import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int T = Integer.parseInt(str[0]);
		str = br.readLine().split(" ");
		int []arr = new int[T];
		for (int tc = 0; tc < T; tc++) {
			arr[tc] = Integer.parseInt(str[tc]);
		}
		int cnt = 1;
		int temp=0;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] == 1)
				dq.offerFirst(cnt);
			else if(arr[i] == 2) {
				temp = dq.pollFirst();
				dq.offerFirst(cnt);
				dq.offerFirst(temp);
			}
			
			else
				dq.offerLast(cnt);
			cnt++;
		}
		for(int i : dq)
			sb.append(i + " ");
		System.out.println(sb.toString());
	}
}
