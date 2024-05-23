import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int T = Integer.parseInt(br.readLine());
		int N;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)	{
				if(pq.isEmpty())	sb.append("0"+"\n");
				else	sb.append(pq.poll()+"\n");
			}
			else	pq.add(N);
			
		}
		System.out.println(sb.toString());
	}
}
