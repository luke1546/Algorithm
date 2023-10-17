import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, 가방[], 보석[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		가방 = new int[K];
		보석 = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			보석[i][0] = M;
			보석[i][1] = V;
		}
		for(int i=0; i<K; i++)	 	가방[i] = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
		Arrays.sort(가방);
		Arrays.sort(보석, (o1,o2) -> o1[0]-o2[0]);
		
		long ans=0;
		for(int i=0, j=0; i<K; i++) {
			while(j < N && 가방[i] >= 보석[j][0])	pq.offer(보석[j++][1]);
			if(!pq.isEmpty()) ans+=pq.poll();
		}
		System.out.println(ans);
	}
}
