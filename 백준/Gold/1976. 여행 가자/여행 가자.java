import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N,M, 도시행렬[][], 여행순서[];	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		도시행렬 = new int[N][N];
		여행순서 = new int[M];
		String str[];
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				도시행렬[i][j] = Integer.parseInt(str[j]);
			}
		}
		str = br.readLine().split(" ");
		boolean p = true;
		for(int i=0; i<M; i++) 여행순서[i] = Integer.parseInt(str[i])-1;
		for(int i=0; i<M-1; i++)	if(!BFS(여행순서[i],여행순서[i+1])) p=false;
		if(p)	System.out.println("YES");
		else	System.out.println("NO");
	}
	private static boolean BFS(int start, int end) {
		Deque<Integer> dq = new ArrayDeque<>();
		boolean visit[] = new boolean[N];
		visit[start] = true;
		dq.offer(start);
		while(!dq.isEmpty()) {
			int x = dq.poll();
			if(x==end)	return true;
			for(int i=0; i<N; i++) {
				if(도시행렬[x][i] != 0 && !visit[i]) {
					visit[i] = true;
					dq.offer(i);
				}
			}
		}
		return false;
	}
}
