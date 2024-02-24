import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Main {
	static int R, C, dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static char map[][];
	static boolean p=false;
	static Deque<int[]> dq = new ArrayDeque<>();
	static Deque<int[]> dq2 = new ArrayDeque<>();
	static Deque<int[]> 점디큐 = new ArrayDeque<>();
	static ArrayList<int[]> al = new ArrayList<>();
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++)	map[i] = br.readLine().toCharArray();
		
		
		for(int i=0; i<R; i++)
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'L')	{
					al.add(new int[] {i,j});
					점디큐.add(new int[] {i,j});
				}
				if(map[i][j] == '.')	점디큐.add(new int[] {i,j});
			}
		
		int ans = 0;
		DFS(al.get(0));
		if(p) {
			System.out.println(ans);
			return;
		}
		
		while(!점디큐.isEmpty()) {
			녹이기(점디큐.peek()[0],점디큐.poll()[1]);
		}
		
		ans++;
		while(true) {
			int l=dq2.size();
			for(int i=0; i<l; i++) {
				int cur[] = dq2.poll();
				if(!visit[cur[0]][cur[1]] && map[cur[0]][cur[1]]!= 'X')
					DFS(cur);
			}
			if(p)	break;
			하루보내기();
			ans++;
		}
		System.out.println(ans);
	}
	private static void DFS(int[] xy) {
		int nr,nc;
		visit[xy[0]][xy[1]] = true;
		if(xy[0] == al.get(1)[0] && xy[1] == al.get(1)[1])	{
			p=true;
			return;
		}
		for(int dir[] : dirs) {
			nr = xy[0] + dir[0];
			nc = xy[1] + dir[1];
			if(nr >=0 && nr < R && nc>=0 && nc<C && !visit[nr][nc]) {
				if(map[nr][nc] != 'X' && map[nr][nc] != 'x') {
					visit[nr][nc] = true;
					DFS(new int[] {nr,nc});
				}else {
					map[nr][nc] = 'x';
					dq2.offer(new int[] {nr,nc});
				}
			}
		}
	}
	private static void 하루보내기() {
		int l = dq.size();
		for(int i=0; i<l; i++)	녹이기(dq.peek()[0], dq.poll()[1]);
	}
	private static void 녹이기(int i, int j) {
		int nr,nc;
		for(int dir[] : dirs) {
			nr = i+dir[0];
			nc = j+dir[1];
			if(nr >=0 && nr < R && nc>=0 && nc<C && (map[nr][nc] == 'X' || map[nr][nc] == 'x')) {
				map[nr][nc] = '?';
				dq.offer(new int[] {nr,nc});
			}
		}
	}
}