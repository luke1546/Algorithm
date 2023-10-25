import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int degrees[] = new int[N];
		for(int i=0; i<N; i++)	al.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int before = Integer.parseInt(st.nextToken())-1;
			int after = Integer.parseInt(st.nextToken())-1;
			degrees[after]++;
			al.get(before).add(after);
		}
		for(int i=0; i<N; i++)	
			if(degrees[i] == 0)	pq.offer(i);
		
		while(!pq.isEmpty()) {
			int p = pq.poll();
			sb.append((p+1) + " ");
			for(Integer i : al.get(p)) {
				degrees[i]--;
				if(degrees[i]==0) pq.offer(i);
			}
		}
		System.out.println(sb.toString());
	}
}
