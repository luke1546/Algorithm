import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			int[] arr = new int[N+2];
			long max = 0;
			for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
			Stack<Integer> stack = new Stack<>();
			stack.push(0);
			for(int i=1; i<=N+1; i++) {
				while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
					int v = stack.pop();
					max = Math.max(max, (long)arr[v] * (i - stack.peek() - 1));
				}
				stack.push(i);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}