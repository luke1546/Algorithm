import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer> hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
			if(o1[0]!=o2[0])	return o1[0]-o2[0];
			return o1[1]-o2[1];
			});
		for(int i=0; i<N; i++) pq.add(new int[] {Integer.parseInt(st.nextToken()),i+1});
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new int[] {c,b});
				hm.put(b, c);
			}else {
				int v[] = pq.peek();
				while(hm.containsKey(v[1])){
					if(v[0] == hm.get(v[1])) break;
					pq.poll();
					v = pq.peek();
				}
				sb.append(v[1]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
