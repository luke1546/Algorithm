import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, map[][], command[][], dirs[][] = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}} ,copyDir[][] = {{-1,-1}, {-1,1},{1,-1},{1,1}};
	static boolean check[][];
	static ArrayDeque<int[]> cloud = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		check = new boolean[N][N];
		command = new int[c][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<c; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			command[i][0] = d;
			command[i][1] = s;
		}
		cloud.offer(new int[] {N-1,0});
		cloud.offer(new int[] {N-1,1});
		cloud.offer(new int[] {N-2,0});
		cloud.offer(new int[] {N-2,1});
		for(int i=0; i<c; i++) {
//			print();
			move(i);
			rain();
			copy();
			create();
		}
		System.out.println(count());
	}
	private static int count() {
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
	private static void create() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j]) check[i][j] = false;
				else if(map[i][j] >= 2) {
					cloud.offer(new int[] {i,j});
					map[i][j]-=2;
				}
			}
		}
	}
	private static void copy() {
		int size = cloud.size();
		for(int i=0; i<size; i++) {
			int cur[] = cloud.poll();
			int cnt = 0;
			for(int dir[] : copyDir) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr>=0 && nr < N && nc>=0 && nc<N && map[nr][nc] > 0) {
					cnt++;
				}
			}
			map[cur[0]][cur[1]]+=cnt;
		}
	}
	private static void rain() {
		int size = cloud.size();
		for(int i=0; i<size; i++) {
			int cur[] = cloud.poll();
			map[cur[0]][cur[1]]++;
			cloud.offer(new int[] {cur[0], cur[1]});
			check[cur[0]][cur[1]] = true;
		}
	}
	private static void move(int n) {
		int size = cloud.size();
		for(int i=0; i<size; i++) {
			int cur[] = cloud.poll();
			int d = command[n][0];
			int s = command[n][1];
			int nr = cur[0] + dirs[d][0]*s;
			int nc = cur[1] + dirs[d][1]*s;
			while(nr < 0) nr+=N;
			while(nc < 0) nc+=N;
			nr%=N;
			nc%=N;
			cloud.offer(new int[] {nr,nc});
		}
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

/*
모든 구름이 di 방향으로 si칸 이동한다.
각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
구름이 모두 사라진다.
2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자.

5 4
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3
3 4
8 1
4 8

77
*/