import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> big = new PriorityQueue<>();
		PriorityQueue<Integer> small = new PriorityQueue<>((o1,o2) -> o2-o1);
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer("");
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				if(i%10 == 0) {st = new StringTokenizer(br.readLine(), " ");}
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int mid=0;
			for(int i=0; i<N; i++) {
				if(i==0) mid = arr[i];
				else {
					if(mid <= arr[i]) big.add(arr[i]);
					else small.add(arr[i]);
				}
				if(Math.abs(big.size() - small.size()) > 1) {
					if(big.size() > small.size()) {
						small.add(mid);
						mid = big.poll();
					}
					else {
						big.add(mid);
						mid = small.poll();
					}
				}
				if(i%2==0) sb.append(mid).append(" ");
			}
			System.out.println(((N+1)/2)+"\n"+sb.toString());
			sb.setLength(0);
			big.clear();
			small.clear();
		}
	}
}
