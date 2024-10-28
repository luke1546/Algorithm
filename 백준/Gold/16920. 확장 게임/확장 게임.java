import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int arr[], R, C, N;
	static ArrayList<Deque<int[]>> list = new ArrayList<>();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		map = new char[R][C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<N; i++) list.add(new ArrayDeque<>());
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > '0' && map[i][j] <= '9') {
					int index = map[i][j] - '1';
					list.get(index).add(new int[] {i,j, arr[index], index+1}); //r, c, 범위, 플레이어번호
				}
			}
		}
		
		int emptyCnt = 0;
		while(emptyCnt != N) {
			emptyCnt = 0;
			for(int t=0; t<N; t++) {
				if(!list.get(t).isEmpty()) {
					bfs(list.get(t), t);
				}else emptyCnt++;
			}
		}
		int answer[] = new int[N];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > '0' && map[i][j] <= '9') {
					int index = map[i][j] - '1';
					answer[index]++;
				}
			}
		}
		for(int i=0; i<N; i++) sb.append(answer[i]).append(" ");
		System.out.println(sb);
	}
	private static void bfs(Deque<int[]> dq, int t) {
		Deque<int[]> temp = new ArrayDeque<>();
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			if(cur[2] == 0) {
				temp.add(new int[] {cur[0],cur[1], arr[cur[3]-1], cur[3]});
				continue;
			}
			for(int dir[] : dirs) {
				int nr = cur[0] + dir[0];
				int nc = cur[1] + dir[1];
				if(nr >=0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
					map[nr][nc] = (char)(cur[3]+'0');
					dq.offer(new int[] {nr,nc,cur[2]-1, cur[3]});
				}
			}
		}
		list.get(t).addAll(temp);
	}
}

/*
3 3 2
1 1
1..
...
..2

6 3
*/