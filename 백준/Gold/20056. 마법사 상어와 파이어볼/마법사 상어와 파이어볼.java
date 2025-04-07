import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int m,s,d,c=1,sd=0;
		Node(int m, int s, int d){
			this.m = m;
			this.s = s;
			this.d = d;
		}
		public void plus(Node node){
			this.m+=node.m;
			this.s+=node.s;
			this.c++;
			if(sd!=-2 && this.d%2 == node.d%2) sd = -1;
			else sd = -2;
		}
		@Override
		public String toString() {
			return this.m+"";
		}
	}
	
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
	static int N, M, K;
	static Node map[][];
	//홀짝 1, 나머지 2
	static int dirs1[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int dirs2[][] = {{-1,-1},{-1,1},{1,1},{1,-1}};
	static int fireDir[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Node[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dq.offer(new int[] {r,c,m,s,d});
		}
		for(int i=0; i<K; i++) {
			move();
			check();
		}
		int sum = 0;
		while(!dq.isEmpty()) {
			sum += dq.poll()[2];
		}
		System.out.println(sum);
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != null) {
					if(map[i][j].c == 1) {
						dq.offer(new int[] {i,j,map[i][j].m, map[i][j].s, map[i][j].d});
					}
					else if(map[i][j].c > 1) {
						explosion(i,j);
					}
					map[i][j] = null;
				}
			}
		}
	}
	private static void explosion(int i, int j) {
		int newM = map[i][j].m/5;
		int newS = map[i][j].s/map[i][j].c;
		if(newM == 0) return;
		int dirs[][];
		int d = 0;
		if(map[i][j].sd == -1) {
			dirs = dirs1;
			d = 0;
		}
		else {
			dirs = dirs2;
			d = 1;
		}
		map[i][j] = null;
		for(int dir[] : dirs) {
			dq.offer(new int[] {i,j,newM, newS, d});
			d+=2;
		}
	}
	private static void move() {
		int size = dq.size();
		for(int i=0; i<size; i++) {
			int cur[] = dq.poll();
			int nr = Math.floorMod(cur[0] + fireDir[cur[4]][0] * cur[3],N);
			int nc = Math.floorMod(cur[1] + fireDir[cur[4]][1] * cur[3],N);
			setFire(nr,nc, cur[2], cur[3], cur[4]);
		}
	}
	private static void setFire(int nr, int nc, int m, int s, int d) {
		if(map[nr][nc] == null) map[nr][nc] = new Node(m, s, d);
		else map[nr][nc].plus(new Node(m,s,d));
	}
}

/*
4 2 1
1 1 5 2 2
1 4 7 1 6

8
*/

