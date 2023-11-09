import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K, foodMap[][], map[][], dirs[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2) -> o1[2]-o2[2]);
	static ArrayDeque<int[]> live = new ArrayDeque<int[]>();
	static ArrayDeque<int[]> dead = new ArrayDeque<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		foodMap = new int[N][N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				foodMap[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {r,c,z});
		}
		
		for(int i=0; i<K; i++) {
			봄();
			여름();
			가을();
			겨울();
		}
		System.out.println(pq.size());
	}
	
	private static void 겨울() {
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j] += foodMap[i][j];
	}

	private static void 가을() {
		while(!live.isEmpty()) {
			int[] tree = live.poll();
			if(tree[2]%5 == 0) {
				for(int dir[] : dirs) {
					int nr = tree[0] + dir[0];
					int nc = tree[1] + dir[1];
					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						pq.offer(new int[] {nr,nc,1});
					}
				}
			}
			pq.offer(tree);
		}
	}

	private static void 여름() {
		while(!dead.isEmpty()) {
			int[] tree = dead.poll();
			map[tree[0]][tree[1]]+=(tree[2]/2);
		}
	}
	private static void 봄() {
		while(!pq.isEmpty()) {
			int[] tree = pq.poll();
			if(map[tree[0]][tree[1]] >= tree[2]) { 
				map[tree[0]][tree[1]]-=tree[2];
				tree[2]++;
				live.offer(tree);
			}else 	dead.offer(tree);
		}		
	}
}
